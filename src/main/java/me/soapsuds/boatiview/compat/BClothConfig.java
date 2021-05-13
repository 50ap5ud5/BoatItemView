package me.soapsuds.boatiview.compat;

import com.google.common.collect.Lists;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class BClothConfig implements ConfigScreenFactory<Screen> {

	@Override
	public Screen create(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create().setParentScreen(parent).setTitle(new LiteralText("Boat Item View"));
        builder.setDefaultBackgroundTexture(new Identifier("minecraft:textures/block/oak_planks.png"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        ConfigCategory client = builder.getOrCreateCategory(new LiteralText("Client Settings"));
        //Toggle Mod
        client.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("config.boatiview.show_hands_in_moving_boat"), true).setTooltip(new LiteralText("Toggle whether the hand should be rendered whilst the boat is moving")).setDefaultValue(true).build());
        //List
        client.addEntry(entryBuilder.startStrList(new TranslatableText("config.boatiview.items_to_show_in_moving_boat"), Lists.newArrayList("minecraft:filled_map")).setTooltip(new LiteralText("List of items that will make the hand display when a boat is moving\nSeperate every entry except the last one with commas")).setDefaultValue(Lists.newArrayList("minecraft:filled_map")).build());
        builder.transparentBackground();
        Screen screen = builder.build();
        return screen;
	}
	
}