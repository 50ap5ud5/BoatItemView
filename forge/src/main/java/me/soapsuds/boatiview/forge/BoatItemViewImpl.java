package me.soapsuds.boatiview.forge;

import fuzs.forgeconfigapiport.forge.api.neoforge.v4.NeoForgeConfigRegistry;
import me.soapsuds.boatiview.BoatItemView;
import me.soapsuds.boatiview.config.BConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(BoatItemView.MODID)
public class BoatItemViewImpl {

	public BoatItemViewImpl() {
		NeoForgeConfigRegistry.INSTANCE.register(BoatItemView.MODID, ModConfig.Type.CLIENT, BConfig.CLIENT_SPEC);
	}
}
