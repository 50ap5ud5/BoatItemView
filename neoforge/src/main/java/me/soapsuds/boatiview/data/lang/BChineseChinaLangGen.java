package me.soapsuds.boatiview.data.lang;

import me.soapsuds.boatiview.util.BTranslationKeys;
import net.minecraft.data.PackOutput;

public class BChineseChinaLangGen extends BEnglishLangGen {

    public BChineseChinaLangGen(PackOutput out) {
        super(out, "zh_cn");
    }

	@Override
	public void addTranslations() {
		//Configs
	    this.addConfigTranslations(BTranslationKeys.CONFIG_SHOW_HANDS, "在移动的船中渲染手持物品");
        this.addConfigTranslations(BTranslationKeys.CONFIG_WHITELIST_ITEMS, "在移动的船中渲染的物品");
        //Config Name for Cloth Config mod used in the Fabric version
        this.add(BTranslationKeys.CONFIG_TITLE, "划船物品显示");
	}
}
