package me.soapsuds.boatiview.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;


public class DataGen implements DataGeneratorEntrypoint{

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		final FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(BLangGen::new);
	}

}
