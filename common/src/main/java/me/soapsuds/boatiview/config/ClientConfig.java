package me.soapsuds.boatiview.config;

import com.google.common.collect.Lists;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import me.soapsuds.boatiview.util.BConstants;

import java.util.List;

@Config(name = BConstants.CONFIG_NAME)
public class ClientConfig implements ConfigData {

    @Comment("Toggle whether the hand should be rendered whilst the boat is moving")
    private boolean show_hands = true;
    @Comment("List of items that will make the hand display when a boat is moving\nSeperate every entry except the last one with commas\nTo include all items for a particular modid use the wildcard character '*'. E.g. modid:*")
    private List<? extends String> whitelisted_items = Lists.newArrayList("minecraft:filled_map");

    public List<? extends String> itemsToShowInMovingBoat(){
        return whitelisted_items;
    }

    public boolean showHandsInMovingBoat(){
        return show_hands;
    }
}