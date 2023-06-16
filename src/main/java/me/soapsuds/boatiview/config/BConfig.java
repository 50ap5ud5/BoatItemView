package me.soapsuds.boatiview.config;

import java.util.List;

import com.google.common.collect.Lists;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import me.soapsuds.boatiview.BoatItemView;
@Config(name = BoatItemView.MODID)
public class BConfig extends PartitioningSerializer.GlobalData {

	@ConfigEntry.Category("client")
	@ConfigEntry.Gui.TransitiveObject
	public ClientConfig client = new ClientConfig();
	
	@Config(name = "client")
    public static class ClientConfig implements ConfigData{
    	@Comment("Toggle whether the hand should be rendered whilst the boat is moving")
		public boolean showHandsInMovingBoat = true;
        @Comment("List of items that will make the hand display when a boat is moving\nSeperate every entry except the last one with commas\nTo include all items for a particular modid use the wildcard character '*'. E.g. modid:*")
    	public List<String> itemsToShowInMovingBoat = Lists.newArrayList("minecraft:filled_map");
    	
        public ClientConfig() {

        }
	}
}
