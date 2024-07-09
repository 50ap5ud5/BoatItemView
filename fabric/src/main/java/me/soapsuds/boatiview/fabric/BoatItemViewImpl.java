package me.soapsuds.boatiview.fabric;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import me.soapsuds.boatiview.config.BConfig;
import me.soapsuds.boatiview.config.BConfigFile;
import net.fabricmc.api.ModInitializer;

public class BoatItemViewImpl implements ModInitializer {

	private static BConfig CONFIG = null;

	public BoatItemViewImpl() {

	}

	@Override
	public void onInitialize() {
//		NeoForgeConfigRegistry.INSTANCE.register(BoatItemView.MODID, ModConfig.Type.CLIENT, BConfig.CLIENT_SPEC);

		AutoConfig.register(BConfigFile.class, PartitioningSerializer.wrap(Toml4jConfigSerializer::new));
		CONFIG = AutoConfig.getConfigHolder(BConfigFile.class).getConfig();
	}

	public static BConfig getConfig(){
		return CONFIG;
	}

}
