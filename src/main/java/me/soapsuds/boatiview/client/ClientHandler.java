package me.soapsuds.boatiview.client;

import me.soapsuds.boatiview.config.BConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class ClientHandler {
	
	public static void modifyHandRender(ClientPlayerEntity clientplayerentity, ItemStack itemstack, ItemStack itemstack1) {
		if (BConfig.CLIENT.showHandsInMovingBoat.get()) {
			if (clientplayerentity.isHandsBusy()) {//Do another check if the hands are busy because our mixin is injected at the method call
				boolean showHandsMainHand = false;
				boolean showHandsOffHand = false;
				for (String entry : BConfig.CLIENT.itemsToShowInMovingBoat.get()) {
					Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(entry));
					if (entry != null) {
						if (itemstack.getItem() == item) {
							System.out.println(itemstack.getItem().getRegistryName().toString());
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
