package me.soapsuds.boatiview.client;

import me.soapsuds.boatiview.config.BConfig;
import me.soapsuds.boatiview.util.BConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class ClientHandler {
    
    public static void modifyHandRender(LocalPlayer clientplayerentity, ItemStack itemstack, ItemStack itemstack1) {
        if (BConfig.CLIENT.showHandsInMovingBoat.get()) {
            if (clientplayerentity.isHandsBusy()) {//Do another check if the hands are busy because our mixin is injected at the method call
                boolean showHandsMainHand = false;
                boolean showHandsOffHand = false;
                for (String entry : BConfig.CLIENT.itemsToShowInMovingBoat.get()) {
                    Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(entry));
                    if (item != null) {
                        if (itemstack.getItem() == item) {
                            showHandsMainHand = true;
                            Minecraft.getInstance().getItemInHandRenderer().mainHandItem = itemstack;                       }
                        if (itemstack1.getItem() == item) {
                            showHandsOffHand = true;
                            Minecraft.getInstance().getItemInHandRenderer().offHandItem = itemstack1;
                        }
                    }
                }
                
                //Increase the hand height so that when the hand is moved down after this mixin, it will appear to remain at 1
                if (showHandsMainHand) {
                    Minecraft.getInstance().getItemInHandRenderer().mainHandHeight = BConstants.EXTRA_HAND_HEIGHT;
                }

                if (showHandsOffHand) {
                    Minecraft.getInstance().getItemInHandRenderer().offHandHeight = BConstants.EXTRA_HAND_HEIGHT;
                }
            }
        }
    }

}
