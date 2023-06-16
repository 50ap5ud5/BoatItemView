package me.soapsuds.boatiview.client;

import me.soapsuds.boatiview.BoatItemView;
import me.soapsuds.boatiview.config.BConfig;
import me.soapsuds.boatiview.util.BConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ClientHandler {
    
    public static void modifyHandRender(LocalPlayer clientplayerentity, ItemStack itemstack, ItemStack itemstack1) {
        BConfig config = BoatItemView.CONFIG;
        if (config.client.showHandsInMovingBoat) {
            if (clientplayerentity.isHandsBusy()) { //Do another check if the hands are busy because our mixin is injected at the method call
                boolean showHandsMainHand = false;
                boolean showHandsOffHand = false;
                for (String entry : config.client.itemsToShowInMovingBoat) {
                	if(entry.endsWith("*")) { //Handle entire modids by using a wildcard character
                		String namespace = entry.substring(0, entry.indexOf(':'));
                	    ResourceLocation mainHandItemLoc = BuiltInRegistries.ITEM.getKey(itemstack.getItem());
                	    ResourceLocation offHandItemLoc = BuiltInRegistries.ITEM.getKey(itemstack1.getItem());
                	    if (mainHandItemLoc.getNamespace().equals(namespace))
                	        showHandsMainHand = showHandItem(itemstack, true);
                	    if (offHandItemLoc.getNamespace().equals(namespace))
                	        showHandsOffHand = showHandItem(itemstack1, false);
                	}
                	else { //Otherwise, check by individual item IDs
                	    Item item = BuiltInRegistries.ITEM.get(new ResourceLocation(entry));
                        if (item != null) {
                            showHandsMainHand = showHandItem(itemstack, item, true);
                            showHandsOffHand = showHandItem(itemstack1, item, false);
                	    }
                    }
                }
                //Increase the hand height so that when the hand is moved down after this mixin, it will appear to remain at 1
                if (showHandsMainHand) {
                    Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer().mainHandHeight = BConstants.EXTRA_HAND_HEIGHT;
                }

                if (showHandsOffHand) {
                    Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer().offHandHeight = BConstants.EXTRA_HAND_HEIGHT;
                }
            }
        }
    }
    /** Handle setting the hand's item (so the hand doesn't magically appear empty) and return a value for if we should display the hand*/
    private static boolean showHandItem(ItemStack handStack, boolean mainHand) {
		if (mainHand)
        	Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer().mainHandItem = handStack;
		else
			Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer().offHandItem = handStack;
		return true;
    }
    /** Alternative version of above method with an equality check by Item instance*/
    private static boolean showHandItem(ItemStack handStack, Item blacklisted, boolean mainHand) {
    	if (handStack.getItem() == blacklisted) {
    		return showHandItem(handStack, mainHand);
    	}
    	return false;
    }

}
