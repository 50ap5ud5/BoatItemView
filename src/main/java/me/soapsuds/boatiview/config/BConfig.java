package me.soapsuds.boatiview.config;

import java.util.List;

import com.google.common.collect.Lists;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.soapsuds.boatiview.BoatItemView;
@Config(name = BoatItemView.MODID)
public class BConfig implements ConfigData {

	@ConfigEntry.Category("client")
	public ClientConfig CLIENT = new ClientConfig();
	
	@Config(name = "client_settings")
    public static class ClientConfig {
    	//@Comment("Toggle whether the hand should be rendered whilst the boat is moving")
    	public boolean showHandsInMovingBoat = true;
    	//@Comment("List of items that will make the hand display when a boat is moving. Seperate every entry except the last one with commas")
    	public List<String> itemsToShowInMovingBoat = Lists.newArrayList("minecraft:filled_map");
    	
        public ClientConfig() {
//        	builder.push("Client Settings");
//    	    this.showHandsInMovingBoat = builder.comment("Toggle whether the hand should be rendered whilst the boat is moving")
//    	    		.translation("config.boatiview.show_hands_in_moving_boat")
//    	    		.define("showHandsInMovingBoat", true);
//    	    this.itemsToShowInMovingBoat = builder.translation("config.boatiview.items_to_show_in_moving_boat")
//                    .comment("List of items that will make the hand display when a boat is moving","Seperate every entry except the last one with commas")
//                    .defineList("itemsToShowInMovingBoat", Lists.newArrayList("minecraft:filled_map"), String.class::isInstance);

        }
    	
    }
}