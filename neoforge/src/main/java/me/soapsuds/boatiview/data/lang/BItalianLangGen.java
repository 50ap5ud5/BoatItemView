package me.soapsuds.boatiview.data.lang;

import me.soapsuds.boatiview.util.BTranslationKeys;
import net.minecraft.data.PackOutput;

public class BItalianLangGen extends BEnglishLangGen {

    public BItalianLangGen(PackOutput out) {
        super(out, "es_es");
    }

	@Override
	public void addTranslations() {
		//Configs
	    this.addConfigTranslations(BTranslationKeys.CONFIG_SHOW_HANDS, "Mostra Oggetti sulla Barca in Movimento");
        this.addConfigTranslations(BTranslationKeys.CONFIG_WHITELIST_ITEMS, "Oggetti da visualizzare sulla Barca in Movimento");
        //Config Name for Cloth Config mod used in the Fabric version
        this.add(BTranslationKeys.CONFIG_TITLE, "Boat Item View");
	}
}
