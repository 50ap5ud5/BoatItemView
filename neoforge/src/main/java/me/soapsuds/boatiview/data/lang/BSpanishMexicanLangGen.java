package me.soapsuds.boatiview.data.lang;

import me.soapsuds.boatiview.util.BTranslationKeys;
import net.minecraft.data.PackOutput;

public class BSpanishMexicanLangGen extends BEnglishLangGen {

    public BSpanishMexicanLangGen(PackOutput out) {
        super(out, "es_mx");
    }

	@Override
	public void addTranslations() {
		//Configs
	    this.addConfigTranslations(BTranslationKeys.CONFIG_SHOW_HANDS, "Objetos que se mostraran cuando el barco esté en movimiento");
        this.addConfigTranslations(BTranslationKeys.CONFIG_WHITELIST_ITEMS, "Mostrar objetos mientras el barco se mueve");
        //Config Name for Cloth Config mod used in the Fabric version
//        this.add(BTranslationKeys.CONFIG_TITLE, "Boat Item View");
	}
}
