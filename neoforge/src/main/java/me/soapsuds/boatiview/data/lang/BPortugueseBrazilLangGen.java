package me.soapsuds.boatiview.data.lang;

import me.soapsuds.boatiview.util.BTranslationKeys;
import net.minecraft.data.PackOutput;

public class BPortugueseBrazilLangGen extends BEnglishLangGen {

    public BPortugueseBrazilLangGen(PackOutput out) {
        super(out, "pt_br");
    }

	@Override
	public void addTranslations() {
		//Configs
	    this.addConfigTranslations(BTranslationKeys.CONFIG_SHOW_HANDS, "Mostrar itens no bote em movimento");
        this.addConfigTranslations(BTranslationKeys.CONFIG_WHITELIST_ITEMS, "Itens em exibição no bote em movimento");
        //Config Name for Cloth Config mod used in the Fabric version
//        this.add(BTranslationKeys.CONFIG_TITLE, "Boat Item View");
	}
}
