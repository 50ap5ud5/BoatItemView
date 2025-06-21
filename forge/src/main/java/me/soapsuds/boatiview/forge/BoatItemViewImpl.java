package me.soapsuds.boatiview.forge;

import me.soapsuds.boatiview.BoatItemView;

import me.soapsuds.boatiview.forge.config.BConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BoatItemView.MODID)
public class BoatItemViewImpl {

	public BoatItemViewImpl(FMLJavaModLoadingContext context) {

		context.registerConfig(ModConfig.Type.CLIENT, BConfig.CLIENT_SPEC);

	}
}
