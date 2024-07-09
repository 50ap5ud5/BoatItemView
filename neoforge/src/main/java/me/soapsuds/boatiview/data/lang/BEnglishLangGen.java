package me.soapsuds.boatiview.data.lang;

import java.util.Arrays;
import java.util.stream.Collectors;

import me.soapsuds.boatiview.BoatItemView;
import me.soapsuds.boatiview.util.BConstants;
import me.soapsuds.boatiview.util.BTranslationKeys;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class BEnglishLangGen extends LanguageProvider {

    public BEnglishLangGen(PackOutput out) {
        this(out, "en_us");
    }

    public BEnglishLangGen(PackOutput out, String locale) {
        super(out, BoatItemView.MODID, locale);
    }

	@Override
	public void addTranslations() {
		//Configs
	    this.addConfigTranslations(BTranslationKeys.CONFIG_SHOW_HANDS, "Show Items in Moving Boat");
        this.addConfigTranslations(BTranslationKeys.CONFIG_WHITELIST_ITEMS, "Items to display in Moving Boat");
        //Config Name for Cloth Config mod used in the Fabric version
        this.add(BTranslationKeys.CONFIG_TITLE, "Boat Item View");
	}

    protected void addConfigTranslations(String key, String translation){
        this.add(BTranslationKeys.configOption(key, BConstants.ConfigType.CLOTH), translation);
        this.add(BTranslationKeys.configOption(key, BConstants.ConfigType.NEOFORGE), translation);
    }


    protected String fixCapitalisations(String text) {
        String original = text.trim().replace("    ", "").replace("_", " ").replace("/", ".");
        String output = Arrays.stream(original.split("\\s+"))
                .map(t -> t.substring(0,1).toUpperCase() + t.substring(1))
                .collect(Collectors.joining(" "));
        return output;
    }
}
