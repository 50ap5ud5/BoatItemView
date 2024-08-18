package me.soapsuds.boatiview.neoforge;

import me.soapsuds.boatiview.BoatItemView;
import me.soapsuds.boatiview.BConfig;

@Mod(BoatItemView.MODID)
public class BoatItemViewForge {

	public BoatItemViewForge() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, BConfig.CLIENT_SPEC);
	}
}
