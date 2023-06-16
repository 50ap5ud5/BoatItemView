package me.soapsuds.boatiview.data;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

import me.soapsuds.boatiview.BoatItemView;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class BLangGen extends LanguageProvider {
    private final DataGenerator generator;
    public BLangGen(DataGenerator gen) {
        super(gen.getPackOutput(), BoatItemView.MODID, "en_us");
        this.generator = gen;
    }

    @Override
    protected void addTranslations() {
       //Configs
       add("config.boatiview.show_hands_in_moving_boat", "Show Items in Moving Boat");
       add("config.boatiview.items_to_show_in_moving_boat", "Items to display in Moving Boat");

    }

    public String fixCapitalisations(String text) {
        String original = text.trim().replace("    ", "").replace("_", " ").replace("/", ".");
        String output = Arrays.stream(original.split("\\s+"))
                .map(t -> t.substring(0,1).toUpperCase() + t.substring(1))
                .collect(Collectors.joining(" "));
        return output;
    }


}
