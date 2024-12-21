package me.soapsuds.boatiview.data.lang;

import me.soapsuds.boatiview.util.BTranslationKeys;
import net.minecraft.data.PackOutput;

public class BFrenchFranceLangGen extends BEnglishLangGen {

    public BFrenchFranceLangGen(PackOutput out) {
        super(out, "fr_fr");
    }

	@Override
	public void addTranslations() {
		//Configs
	    this.addConfigTranslations(BTranslationKeys.CONFIG_SHOW_HANDS, "Montrer les items dans le bateau en mouvement");
        this.addConfigTranslations(BTranslationKeys.CONFIG_WHITELIST_ITEMS, "Items à afficher dans le bateau pendant la nagigation");
        //Config Name for Cloth Config mod used in the Fabric version and Config type (Client/Common/Server) in Neoforge
        this.addConfigTitleTranslation("Boat Item View");
        //Neoforge Config translations
        this.add(BTranslationKeys.CLIENT_CONFIG_TITLE, "Boat Item View Client");
        this.add(BTranslationKeys.CLIENT_CONFIG_SECTION, "Client settings");
        this.add(BTranslationKeys.CLIENT_CONFIG_SECTION_TITLE, "Client settings");
        this.add(BTranslationKeys.configComment(BTranslationKeys.CONFIG_SHOW_HANDS), "Toggle whether the item in hand should be rendered whilst the boat is moving");
        this.add(BTranslationKeys.configComment(BTranslationKeys.CONFIG_WHITELIST_ITEMS), "Items that will remain displayed in hand. Adding the character '*' after a Mod ID will include all items from the mod. E.g. 'modid:*'. If no Mod ID is specified before the '*' character, all items will be included. E.g. '*'");
	}
}
