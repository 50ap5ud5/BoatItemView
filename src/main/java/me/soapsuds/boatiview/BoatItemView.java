package me.soapsuds.boatiview;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.soapsuds.boatiview.config.BConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.network.FMLNetworkConstants;

@Mod(BoatItemView.MODID)
public class BoatItemView {
	
	public static final String MODID = "boatiview";
	
	public static Logger LOGGER = LogManager.getLogger(MODID);
	
	public BoatItemView() {
		
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, BConfig.CLIENT_SPEC);
		ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> FMLNetworkConstants.IGNORESERVERONLY, (incoming, isNetwork) -> true));
		
	}

}
