package me.soapsuds.boatiview.forge;

import me.soapsuds.boatiview.BoatItemView;

import me.soapsuds.boatiview.forge.config.BConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BoatItemView.MODID)
public class BoatItemViewImpl {

	public BoatItemViewImpl(FMLJavaModLoadingContext context) {
		IEventBus modEventBus = context.getModEventBus();
		context.registerConfig(ModConfig.Type.CLIENT, BConfig.CLIENT_SPEC);

	}
}
