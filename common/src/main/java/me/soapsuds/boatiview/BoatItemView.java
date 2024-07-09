package me.soapsuds.boatiview;

import dev.architectury.injectables.annotations.ExpectPlatform;
import me.soapsuds.boatiview.config.BConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BoatItemView {

	public static final String MODID = "boatiview";

	public static Logger LOGGER = LogManager.getLogger(MODID);

	public BoatItemView() {

	}

	@ExpectPlatform
	public static BConfig getConfig(){
		throw new AssertionError();
	}
}
