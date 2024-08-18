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
		modEventBus.addListener(this::onInitializeDataGenerator);

		modContainer.registerConfig(ModConfig.Type.CLIENT, BConfig.CLIENT_SPEC);
	}

	public void onInitializeDataGenerator(GatherDataEvent e) {
		DataGenerator generator = e.getGenerator();
		ExistingFileHelper existingFileHelper = e.getExistingFileHelper();
		generator.addProvider(e.includeClient(), new BEnglishLangGen(generator.getPackOutput()));
		generator.addProvider(e.includeClient(), new BChineseChinaLangGen(generator.getPackOutput()));
		generator.addProvider(e.includeClient(), new BFrenchFranceLangGen(generator.getPackOutput()));
		generator.addProvider(e.includeClient(), new BPortugueseBrazilLangGen(generator.getPackOutput()));
		generator.addProvider(e.includeClient(), new BSpanishLangGen(generator.getPackOutput()));
		generator.addProvider(e.includeClient(), new BSpanishMexicanLangGen(generator.getPackOutput()));
		generator.addProvider(e.includeClient(), new BItalianLangGen(generator.getPackOutput()));
	}
}
