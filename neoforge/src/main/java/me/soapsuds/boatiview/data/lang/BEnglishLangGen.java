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
        //Config Name for Cloth Config mod used in the Fabric version and Config type (Client/Common/Server) in Neoforge
        this.addConfigTitleTranslation("Boat Item View");
        //Neoforge Config translations
        this.add(BTranslationKeys.CLIENT_CONFIG_TITLE, "Boat Item View Client");
        this.add(BTranslationKeys.CLIENT_CONFIG_SECTION, "Client settings");
        this.add(BTranslationKeys.CLIENT_CONFIG_SECTION_TITLE, "Client settings");
        this.add(BTranslationKeys.configComment(BTranslationKeys.CONFIG_SHOW_HANDS), "Toggle whether the item in hand should be rendered whilst the boat is moving");
        this.add(BTranslationKeys.configComment(BTranslationKeys.CONFIG_WHITELIST_ITEMS), "Items that will remain displayed in hand. Adding the character '*' after a Mod ID will include all items from the mod. E.g. 'modid:*'. If no Mod ID is specified before the '*' character, all items will be included. E.g. '*'");
	}

    protected void addConfigTranslations(String key, String translation){
        this.add(BTranslationKeys.configOption(key, BConstants.ConfigType.CLOTH), translation);
        this.add(BTranslationKeys.configOption(key, BConstants.ConfigType.NEOFORGE), translation);
    }

    protected void addConfigTitleTranslation(String translation){
        this.add(BTranslationKeys.configTitle(BConstants.ConfigType.CLOTH), translation);
        this.add(BTranslationKeys.configTitle(BConstants.ConfigType.NEOFORGE), translation);
    }


    protected String fixCapitalisations(String text) {
        String original = text.trim().replace("    ", "").replace("_", " ").replace("/", ".");
        String output = Arrays.stream(original.split("\\s+"))
                .map(t -> t.substring(0,1).toUpperCase() + t.substring(1))
                .collect(Collectors.joining(" "));
        return output;
    }
}
