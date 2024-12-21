package me.soapsuds.boatiview.util;


import me.soapsuds.boatiview.BoatItemView;
import me.soapsuds.boatiview.util.BConstants.ConfigType;

public class BTranslationKeys {

    public static String CONFIG_SHOW_HANDS = "show_hands";

    public static String CONFIG_WHITELIST_ITEMS = "whitelisted_items";

    public static String CLIENT_CONFIG_TITLE = BoatItemView.MODID + ".configuration.client";

    public static String CLIENT_CONFIG_FILE_NAME = BoatItemView.MODID + ".client.toml";

    public static String CLIENT_CONFIG_SECTION = BoatItemView.MODID + ".configuration.section." + CLIENT_CONFIG_FILE_NAME;

    public static String CLIENT_CONFIG_SECTION_TITLE = BoatItemView.MODID + ".configuration.section." + CLIENT_CONFIG_FILE_NAME + ".title";

    public static String configTitle(ConfigType type){
        String clothKey = "text.autoconfig." + BConstants.CONFIG_NAME + ".title";
        String neoForgeKey = BoatItemView.MODID + ".configuration.title";
        return type == ConfigType.CLOTH ? clothKey : neoForgeKey;
    }

    public static String configOption(String key, ConfigType type){
        String clothKey = "text.autoconfig." + BConstants.CONFIG_NAME + ".option." + key;
        String neoForgeKey = BoatItemView.MODID + ".configuration." + key; //See format in https://github.com/neoforged/NeoForge/blob/b71b520e69b1faa6f4bf684fd75ebd41245285f1/src/main/java/net/neoforged/neoforge/client/gui/ConfigurationScreen.java#L552
        return type == ConfigType.CLOTH ? clothKey : neoForgeKey;
    }

    /**
     * Variant to be used for Neoforge configs which allow translation of the config option
     * @param key
     * @return
     */
    public static String configOption(String key){
       return BoatItemView.MODID + ".configuration." + key;
    }

    /**
     * Create translation key for Neoforge Config Comment
     * See https://github.com/neoforged/NeoForge/blob/b71b520e69b1faa6f4bf684fd75ebd41245285f1/src/main/java/net/neoforged/neoforge/client/gui/ConfigurationScreen.java#L572
     * @param key
     * @return
     */
    public static String configComment(String key){
        return configOption(key, ConfigType.NEOFORGE) + ".tooltip";
    }
}