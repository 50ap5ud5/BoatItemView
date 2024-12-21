package me.soapsuds.boatiview.fabric.config;

import com.google.common.collect.Lists;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import me.soapsuds.boatiview.util.BConstants;

import java.util.List;

@Config(name = BConstants.CONFIG_NAME)
public class BConfig implements ConfigData {

    @Comment("Toggle whether the item held in hand should be rendered whilst the boat is moving")
    public boolean show_hands = true;
    @Comment("List of items that will make the hand display when a boat is moving. Seperate every entry except the last one with commas\nTo include all items for a particular modid use the wildcard character '*'. E.g. modid:*.\nIf no Mod ID is specified before the '*' character, all items will be included. E.g. '*'")
    public List<String> whitelisted_items = Lists.newArrayList("minecraft:filled_map");

}
