package me.soapsuds.boatiview.client;


import me.soapsuds.boatiview.platform.Services;
import me.soapsuds.boatiview.util.BConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;


public class ClientHandler {
    
    public static void modifyHandRender(LocalPlayer clientplayerentity, ItemStack itemstack, ItemStack itemstack1) {
        if (Services.CONFIG_HELPER.showHands()) {
            if (clientplayerentity.isHandsBusy()) { //Do another check if the hands are busy because our mixin is injected at the method call
                boolean showHandsMainHand = false;
                boolean showHandsOffHand = false;
                List<? extends String> entries = Services.CONFIG_HELPER.whitelistedItems();
                for (String entry : entries) {
                    if (entry.equals("*")){ //Handle allowing every item from all mods
                        showHandsMainHand = true;
                        showHandItem(itemstack, true);
                        showHandsOffHand = true;
                        showHandItem(itemstack1, false);
                        break;
                    }
                    if(entry.endsWith("*")) { //Handle entire modids by using a wildcard character
                		String namespace = entry.substring(0, entry.indexOf(':'));
                	    ResourceLocation mainHandItemLoc = BuiltInRegistries.ITEM.getKey(itemstack.getItem());
                	    ResourceLocation offHandItemLoc = BuiltInRegistries.ITEM.getKey(itemstack1.getItem());
                	    if (mainHandItemLoc.getNamespace().equals(namespace))
                	        showHandsMainHand = showHandItem(itemstack, true);
                	    if (offHandItemLoc.getNamespace().equals(namespace))
                	        showHandsOffHand = showHandItem(itemstack1, false);
                        break;
                	}
                	else { //Otherwise, check by individual item IDs
                	    ResourceLocation item = ResourceLocation.parse(entry);
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
    private static boolean showHandItem(ItemStack handStack, ResourceLocation whitelisted, boolean mainHand) {
    	if (BuiltInRegistries.ITEM.getKey(handStack.getItem()).equals(whitelisted)) {
    		return showHandItem(handStack, mainHand);
    	}
    	return false;
    }

}
