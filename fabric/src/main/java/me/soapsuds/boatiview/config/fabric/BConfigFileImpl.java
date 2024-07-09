//package me.soapsuds.boatiview.config.fabric;
//
//import me.shedaniel.autoconfig.annotation.Config;
//import me.shedaniel.autoconfig.annotation.ConfigEntry;
//import me.soapsuds.boatiview.BoatItemView;
//import me.soapsuds.boatiview.config.BConfigFile;
//import me.soapsuds.boatiview.config.ClientConfig;
//import me.soapsuds.boatiview.util.BConstants;
//
//@Config(name = BoatItemView.MODID)
//public class BConfigFileImpl extends BConfigFile {
//
//	@ConfigEntry.Category(BConstants.CONFIG_NAME)
//	@ConfigEntry.Gui.TransitiveObject
//	public static ClientConfig clientConfig = new ClientConfig();
//
//	//Fabric implementation of method in common module
//	public static ClientConfig getClientConfig(){
//		return clientConfig;
//	}
//
//	@Override
//	public ClientConfig clientConfig() {
//		return getClientConfig();
//	}
//
//}