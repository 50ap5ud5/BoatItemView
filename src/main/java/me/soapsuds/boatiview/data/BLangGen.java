package me.soapsuds.boatiview.data;

import java.util.Arrays;
import java.util.stream.Collectors;

import me.soapsuds.boatiview.BoatItemView;
import net.minecraft.data.DataGenerator;

public class BLangGen extends CustomLangGenerator {
    private final DataGenerator generator;
    public BLangGen(DataGenerator gen) {
        super(gen, BoatItemView.MODID, "en_us");
        this.generator = gen;
    }

    @Override
    protected void addTranslationedNames() {
       //Configs
       add("text.autoconfig.boatiview.option.client.showHandsInMovingBoat", "Show Items in Moving Boat");
       add("text.autoconfig.boatiview.option.client.itemsToShowInMovingBoat", "Items to display in Moving Boat");
       add("text.autoconfig.boatiview.title", "Boat Item View");

    }

    public String fixCapitalisations(String text) {
        String original = text.trim().replace("    ", "").replace("_", " ").replace("/", ".");
        String output = Arrays.stream(original.split("\\s+"))
                .map(t -> t.substring(0,1).toUpperCase() + t.substring(1))
                .collect(Collectors.joining(" "));
        return output;
    }


}
