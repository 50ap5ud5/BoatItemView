package me.soapsuds.boatiview.fabric;


import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import me.soapsuds.boatiview.BoatItemView;
import me.soapsuds.boatiview.config.BConfig;
import net.fabricmc.api.ModInitializer;
import net.neoforged.fml.config.ModConfig;

public class BoatItemViewImpl implements ModInitializer {

	public BoatItemViewImpl() {

	}

	@Override
	public void onInitialize() {
		NeoForgeConfigRegistry.INSTANCE.register(BoatItemView.MODID, ModConfig.Type.CLIENT, BConfig.CLIENT_SPEC);
	}

}
