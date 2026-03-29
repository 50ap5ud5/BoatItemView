package me.soapsuds.boatiview.util;

import me.soapsuds.boatiview.BoatItemView;

public class BConstants {
	
	public static final float EXTRA_HAND_HEIGHT = 1.4F;
	
	public static final String CLOTH_CONFIG_MODID = "cloth-config"; //1.14 to 1.17 = cloth-config2. 1.18-1.21 = cloth_config. 1.21+ = cloth-config

	public static final String FORGE_CONFIG_API_PORT_MODID = "forgeconfigscreens";
	/**
	 * This is the config name used for Forge and Neoforge.
	 * Forge and Neoforge append the name of the config to the mod id and use it in config section translation keys and the config file name
	 * E.g. Config Name = "boatiview_forge"
	 * File Name = "boatiview-boatiview_forge.toml"
	 * Config Section Translation Key = "boatiview.configuration.boatiview.boatiview_forge.toml.title"
	 * Config Option Translation Key = "boatiview.configuration.my_config_option"
	 */
	public static final String CONFIG_NAME_FORGE = "client";
	/**
	 * This is the config name used for the Fabric version which uses Cloth Config API
	 * Cloth Config used by Fabric version uses the explicit name for config file name and translation text
	 * E.g. Config Name = "boatiview_fabric"
	 * File Name = "boatiview_fabric.toml"
	 * Config Option Translation Key = "text.autoconfig.boatiview.boatiview_fabricConfig.my_config_option"
	 * The exception to this rule is when PartitioningSerializer is used, whereby the main config will become a folder and child configs become separate files
	 * E.g. Main Config Name = "boatiview"
	 * Child Config = "client"
	 * Config Path = ".minecraft/config/boatiview/client.toml
	 * Config Option Translation Key = "text.autoconfig.boatiview.clientConfig.my_config_option".
	 * The word "Config" with uppercase C is automatically added to the name of the config so we need to account for this in all translation keys
	 */
	public static final String CONFIG_NAME_CLOTH_CONFIG = "client";

	public enum ConfigType {
		CLOTH,
		NEOFORGE
	}

}
