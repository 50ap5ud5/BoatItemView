package me.soapsuds.boatiview;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import me.soapsuds.boatiview.config.BConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.ActionResult;


public class BoatItemView implements ModInitializer {

	public static final String MODID = "boatiview";

	public static Logger LOGGER = LogManager.getLogger(MODID);
	
	public static BConfig CONFIG = null;

	public BoatItemView() {

	}

	@Override
	public void onInitialize() {
		AutoConfig.register(BConfig.class, Toml4jConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(BConfig.class).getConfig();
		AutoConfig.getConfigHolder(BConfig.class).registerSaveListener((manager, data) -> {
            return ActionResult.SUCCESS;
        });
	}
}
