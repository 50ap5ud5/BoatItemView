package me.soapsuds.boatiview.data.lang;

import me.soapsuds.boatiview.util.BTranslationKeys;
import net.minecraft.data.PackOutput;

public class BFrenchFranceGen extends BEnglishLangGen {

    public BFrenchFranceGen(PackOutput out) {
        super(out, "fr_fr");
    }

	@Override
	public void addTranslations() {
		//Configs
	    this.addConfigTranslations(BTranslationKeys.CONFIG_SHOW_HANDS, "Montrer les items dans le bateau en mouvement");
        this.addConfigTranslations(BTranslationKeys.CONFIG_WHITELIST_ITEMS, "Items à afficher dans le bateau pendant la nagigation");
        //Config Name for Cloth Config mod used in the Fabric version
        this.add(BTranslationKeys.CONFIG_TITLE, "Boat Item View");
	}
}
