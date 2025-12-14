package me.soapsuds.boatiview.client;


import me.soapsuds.boatiview.platform.Services;
import me.soapsuds.boatiview.util.BConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.stream.Collectors;


public class ClientHandler {
    
    public static void modifyHandRender(LocalPlayer clientplayerentity, ItemStack itemstack, ItemStack itemstack1) {
        if (Services.CONFIG_HELPER.showHands()) {
            if (clientplayerentity.isHandsBusy()) { //Do another check if the hands are busy because our mixin is injected at the method call
                List<? extends String> entries = Services.CONFIG_HELPER.whitelistedItems();
                if (!entries.isEmpty()){ //Only change hand height if the list is not empty to account for bad user inputs
                    List<? extends String> distinctList = entries.stream().distinct().collect(Collectors.toList());
                    int matchingMainHandItems = 0;
                    int matchingOffHandItems = 0;
                    for (String entry : distinctList) {
                        if (entry.equals("*")){ //Handle allowing every item from all mods
                            matchingMainHandItems++;
                            showHandItem(itemstack, true);
                            matchingOffHandItems++;
                            showHandItem(itemstack1, false);
                            break; //Break the loop and don't check further entries
                        }

                        //Handle all items in a modid being whitelisted
                        if(entry.endsWith("*")) { //Handle entire modids by using a wildcard character
                            String namespace = entry.substring(0, entry.indexOf(':'));
                            Identifier mainHandItemLoc = BuiltInRegistries.ITEM.getKey(itemstack.getItem());
                            Identifier offHandItemLoc = BuiltInRegistries.ITEM.getKey(itemstack1.getItem());
                            if (mainHandItemLoc.getNamespace().equals(namespace)) {
                                if(showHandItem(itemstack, true))
                                    matchingMainHandItems++;
                            }
                            if (offHandItemLoc.getNamespace().equals(namespace)) {
                                if(showHandItem(itemstack1, false))
                                    matchingOffHandItems++;
                            }
                        }

                        //If one hand comes from a modid that was whitelisted, continue to check both offhand and mainhand by individual item IDs
                        //Handles when one hand is an item that has had their entire modid whitelisted and another hand has an item from a different modid which has not had the entire modid whitelisted
                        Identifier item = Identifier.parse(entry);
                        if (item != null) {
                            if(showHandItem(itemstack, item, true))
                                matchingMainHandItems++;
                            if(showHandItem(itemstack1, item, false))
                                matchingOffHandItems++;
                        }

                    }

                    boolean showHandsMainHand = matchingMainHandItems > 0; //Show main hand if at least 1 item in the whitelist entries matched the current held mainhand item
                    boolean showHandsOffHand = matchingOffHandItems > 0; //Show offhand hand if at least 1 item in the whitelist entries matched the current held offhand item

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
    private static boolean showHandItem(ItemStack handStack, Identifier whitelisted, boolean mainHand) {
    	if (BuiltInRegistries.ITEM.getKey(handStack.getItem()).equals(whitelisted)) {
    		return showHandItem(handStack, mainHand);
    	}
    	return false;
    }

}
