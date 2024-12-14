package me.soapsuds.boatiview.neoforge;

import me.soapsuds.boatiview.BoatItemView;
import me.soapsuds.boatiview.config.BConfig;
import me.soapsuds.boatiview.data.lang.*;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;


@Mod(BoatItemView.MODID)
public class BoatItemViewImpl {

	private static BConfig CONFIG = null;

	public BoatItemViewImpl(IEventBus modEventBus, ModContainer modContainer) {
		modEventBus.addListener(this::onGatherData);

		modContainer.registerConfig(ModConfig.Type.CLIENT, BConfig.CLIENT_SPEC);
	}

	public void onGatherData(GatherDataEvent.Client e) {
		DataGenerator generator = e.getGenerator();
		ExistingFileHelper existingFileHelper = e.getExistingFileHelper();
		generator.addProvider(true, new BEnglishLangGen(generator.getPackOutput()));
		generator.addProvider(true, new BChineseChinaLangGen(generator.getPackOutput()));
		generator.addProvider(true, new BFrenchFranceLangGen(generator.getPackOutput()));
		generator.addProvider(true, new BPortugueseBrazilLangGen(generator.getPackOutput()));
		generator.addProvider(true, new BSpanishLangGen(generator.getPackOutput()));
		generator.addProvider(true, new BSpanishMexicanLangGen(generator.getPackOutput()));
		generator.addProvider(true, new BItalianLangGen(generator.getPackOutput()));
	}
}
