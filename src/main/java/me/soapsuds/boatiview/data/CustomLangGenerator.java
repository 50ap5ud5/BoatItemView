package me.soapsuds.boatiview.data;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
/** Extensible Minecraft Language File generator. Based off MinecraftForge's LangProvider*/
public abstract class CustomLangGenerator implements DataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private final Map<String, String> dataToTranslate = new TreeMap<>(); //Use Treemap to order by key and reduce memory usage. We also don't care are preserving insertion order (Won't need to worry about order, they'll still be sorted by key in the end)
    private final DataGenerator gen;
    private final String modid;
    private final String locale;
    /**
     * @param gen - Data generator instance
     * @param modid - the unique identifier for a mod
     * @param locale - Country language locale E.g. en_us for US English, en_au for Australian English
     */
    public CustomLangGenerator(DataGenerator gen, String modid, String locale) {
        this.gen = gen;
        this.modid = modid;
        this.locale = locale;
    }
    /** Add Translations Keys and their translations here*/
    protected abstract void addTranslationKeyAndNames();

    @Override
    public void run(CachedOutput cache) throws IOException {
        addTranslationKeyAndNames();
        if (!dataToTranslate.isEmpty())
            save(cache, dataToTranslate, this.gen.getOutputFolder().resolve("assets/" + modid + "/lang/" + locale + ".json"));
    }

    @Override
    public String getName() {
        return "Language Locale: " + locale;
    }

    private void save(CachedOutput cache, Object object, Path target) throws IOException {
        JsonObject json = new JsonObject();
        for (Map.Entry<String, String> pair : dataToTranslate.entrySet()) {
            json.addProperty(pair.getKey(), pair.getValue());
        }

        DataProvider.saveStable(cache, json, target);
    }

    /** Adds the specified key-value pair to the map. Each pair must be unique*/
    public void add(String key, String value) {
        if (dataToTranslate.put(key, value) != null)
            throw new IllegalStateException("Duplicate translation key " + key);
    }
}