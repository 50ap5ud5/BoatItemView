package me.soapsuds.boatiview.client;


import me.shedaniel.autoconfig.AutoConfig;
import me.soapsuds.boatiview.config.BConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ClientHandler {
	
	public static void modifyHandRender(LocalPlayer clientplayerentity, ItemStack itemstack, ItemStack itemstack1) {
		BConfig config = AutoConfig.getConfigHolder(BConfig.class).getConfig();
		if (config.CLIENT.showHandsInMovingBoat) {
			if (clientplayerentity.isHandsBusy()) {//Do another check if the hands are busy because our mixin is injected at the method call
				boolean showHandsMainHand = false;
				boolean showHandsOffHand = false;
				for (String entry : config.CLIENT.itemsToShowInMovingBoat) {
					Item item = Registry.ITEM.get(new ResourceLocation(entry));
					if (entry != null) {
						if (itemstack.getItem() == item) {
							showHandsMainHand = true;
						}
						if (itemstack1.getItem() == item) {
							showHandsOffHand = true;
						}
					}
				}
				
				//Increase the hand height so that when the hand is moved down after this mixin, it will appear to remain at 1
		        if (showHandsMainHand) {
		        	Minecraft.getInstance().getItemInHandRenderer().mainHandHeight = 1.4F;
		        }

		        if (showHandsOffHand) {
		        	 Minecraft.getInstance().getItemInHandRenderer().offHandHeight = 1.4F;
		        }
			}
		}
	}

}