package me.soapsuds.boatiview.data;

import java.util.Arrays;
import java.util.stream.Collectors;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class BLangGen extends FabricLanguageProvider {

    public BLangGen(FabricDataOutput out) {
        super(out, "en_us");
    }

	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		//Configs
	    translationBuilder.add("text.autoconfig.boatiview.option.client.showHandsInMovingBoat", "Show Items in Moving Boat");
	    translationBuilder.add("text.autoconfig.boatiview.option.client.itemsToShowInMovingBoat", "Items to display in Moving Boat");
	    translationBuilder.add("text.autoconfig.boatiview.title", "Boat Item View");
	}


    public String fixCapitalisations(String text) {
        String original = text.trim().replace("    ", "").replace("_", " ").replace("/", ".");
        String output = Arrays.stream(original.split("\\s+"))
                .map(t -> t.substring(0,1).toUpperCase() + t.substring(1))
                .collect(Collectors.joining(" "));
        return output;
    }



}
