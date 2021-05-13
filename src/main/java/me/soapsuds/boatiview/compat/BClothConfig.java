package me.soapsuds.boatiview.compat;

import com.google.common.collect.Lists;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.soapsuds.boatiview.BoatItemView;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class BClothConfig implements ConfigScreenFactory<Screen> {

	@Override
	public Screen create(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create().setParentScreen(parent).setTitle(new TextComponent("Boat Item View"));
        builder.setDefaultBackgroundTexture(new ResourceLocation("minecraft:textures/block/oak_planks.png"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        ConfigCategory client = builder.getOrCreateCategory(new TextComponent("Client Settings"));
        //Toggle Mod
        client.addEntry(entryBuilder.startBooleanToggle(new TranslatableComponent("config.boatiview.show_hands_in_moving_boat"), true).setTooltip(new TextComponent("Toggle whether the hand should be rendered whilst the boat is moving")).setDefaultValue(true).setSaveConsumer(b -> BoatItemView.CONFIG.CLIENT.showHandsInMovingBoat = b).build());
        //List
        client.addEntry(entryBuilder.startStrList(new TranslatableComponent("config.boatiview.items_to_show_in_moving_boat"), Lists.newArrayList("minecraft:filled_map")).setTooltip(new TextComponent("List of items that will make the hand display when a boat is moving\nSeperate every entry except the last one with commas")).setDefaultValue(Lists.newArrayList("minecraft:filled_map")).setSaveConsumer(l -> BoatItemView.CONFIG.CLIENT.itemsToShowInMovingBoat = l).build());
        builder.transparentBackground();
        Screen screen = builder.build();
        return screen;
	}
	
}