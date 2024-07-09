package me.soapsuds.boatiview.data.lang;

import me.soapsuds.boatiview.util.BTranslationKeys;
import net.minecraft.data.PackOutput;

public class BSpanishLangGen extends BEnglishLangGen {

    public BSpanishLangGen(PackOutput out) {
        super(out, "es_es");
    }

	@Override
	public void addTranslations() {
		//Configs
	    this.addConfigTranslations(BTranslationKeys.CONFIG_SHOW_HANDS, "Objetos que se mostraran cuando el barco se esté moviendo");
        this.addConfigTranslations(BTranslationKeys.CONFIG_WHITELIST_ITEMS, "Mostrar objetos mientras el barco está en movimiento");
        //Config Name for Cloth Config mod used in the Fabric version
        this.add(BTranslationKeys.CONFIG_TITLE, "Boat Item View");
	}
}
