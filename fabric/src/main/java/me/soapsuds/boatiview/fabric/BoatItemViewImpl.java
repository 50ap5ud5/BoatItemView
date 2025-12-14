package me.soapsuds.boatiview.fabric;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import me.soapsuds.boatiview.fabric.config.BConfig;

public class BoatItemViewImpl implements ModInitializer {

	public static ConfigHolder<BConfig> CONFIG;

	public BoatItemViewImpl() {

	}

	@Override
	public void onInitialize() {
		CONFIG = AutoConfig.register(BConfig.class, PartitioningSerializer.wrap(Toml4jConfigSerializer::new));
	}

}
