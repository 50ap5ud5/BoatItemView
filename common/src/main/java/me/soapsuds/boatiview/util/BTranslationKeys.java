package me.soapsuds.boatiview.util;


import me.soapsuds.boatiview.BoatItemView;
import me.soapsuds.boatiview.util.BConstants.ConfigType;

public class BTranslationKeys {

    public static String CONFIG_SHOW_HANDS = "show_hands";

    public static String CONFIG_WHITELIST_ITEMS = "whitelisted_items";

    public static String CONFIG_TITLE = configTitle();

    public static String configTitle(){
        return "text.autoconfig." + BoatItemView.MODID + ".title";
    }

    public static String configOption(String key, ConfigType type){
        String clothKey = "text.autoconfig." + BoatItemView.MODID + ".option." + BConstants.CONFIG_NAME + "." + key;
        String neoForgeKey = "config." + BoatItemView.MODID + ".option." + key;
        return type == ConfigType.CLOTH ? clothKey : neoForgeKey;
    }

    public static String configComment(String key){
        return "config." + BoatItemView.MODID + ".comment." + BConstants.CONFIG_NAME + "." + key;
    }
}