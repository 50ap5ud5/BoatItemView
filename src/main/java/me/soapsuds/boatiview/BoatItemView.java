package me.soapsuds.boatiview;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import me.soapsuds.boatiview.config.BConfig;
import net.fabricmc.api.ModInitializer;


public class BoatItemView implements ModInitializer {

	public static final String MODID = "boatiview";

	public static Logger LOGGER = LogManager.getLogger(MODID);

	public BoatItemView() {

	}

	@Override
	public void onInitialize() {
		AutoConfig.register(BConfig.class, Toml4jConfigSerializer::new);
	}

}
