package me.soapsuds.boatiview.config;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class BConfig {
	
	public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;
    
    static {
    	Pair<ClientConfig, ForgeConfigSpec> specClientPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specClientPair.getRight();
        CLIENT = specClientPair.getLeft();
    }
    
    public static class ClientConfig {
    	public BooleanValue showHandsInMovingBoat;
    	public ConfigValue<List<? extends String>> itemsToShowInMovingBoat;
    	
        public ClientConfig(ForgeConfigSpec.Builder builder) {
        	builder.push("Client Settings");
    	    this.showHandsInMovingBoat = builder.comment("Toggle whether the hand should be rendered whilst the boat is moving")
    	    		.translation("config.boatiview.show_hands_in_moving_boat")
    	    		.define("showHandsInMovingBoat", true);
    	    this.itemsToShowInMovingBoat = builder.translation("config.boatiview.items_to_show_in_moving_boat")
                    .comment("List of items that will make the hand display when a boat is moving","Seperate every entry except the last one with commas","To include all items for a particular modid use the wildcard character '*'. E.g. modid:*")
                    .defineList("itemsToShowInMovingBoat", Lists.newArrayList("minecraft:filled_map"), String.class::isInstance);
    	    		
    	    builder.pop();
        }
    	
    }
}
