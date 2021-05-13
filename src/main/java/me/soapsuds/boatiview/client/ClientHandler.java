package me.soapsuds.boatiview.client;

import me.soapsuds.boatiview.BoatItemView;
import me.soapsuds.boatiview.config.BConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ClientHandler {
	
	public static void modifyHandRender(ClientPlayerEntity clientplayerentity, ItemStack itemstack, ItemStack itemstack1) {
		BConfig config = BoatItemView.CONFIG;
		if (config.CLIENT.showHandsInMovingBoat) {
			if (clientplayerentity.isRiding()) { //Do another check if the hands are busy because our mixin is injected at the method call
				boolean showHandsMainHand = false;
				boolean showHandsOffHand = false;
				for (String entry : config.CLIENT.itemsToShowInMovingBoat) {
					Item item = Registry.ITEM.get(new Identifier(entry));
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
		        	MinecraftClient.getInstance().getHeldItemRenderer().equipProgressMainHand = 1.4F;
		        }

		        if (showHandsOffHand) {
		        	MinecraftClient.getInstance().getHeldItemRenderer().equipProgressOffHand = 1.4F;
		        }
			}
		}
	}

}
