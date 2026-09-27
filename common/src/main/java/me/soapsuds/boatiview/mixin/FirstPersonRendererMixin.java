package me.soapsuds.boatiview.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import me.soapsuds.boatiview.client.ClientHandler;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.player.FirstPersonHandsAndItems;
import net.minecraft.world.item.ItemStack;

@Mixin(FirstPersonHandsAndItems.class)
public class FirstPersonRendererMixin {

	@Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isHandsBusy()Z"), locals = LocalCapture.CAPTURE_FAILSOFT)
	public void modifyHandRender(LocalPlayer player, CallbackInfo ci, ItemStack nextMainHand, ItemStack nextOffHand) {
		ClientHandler.modifyHandRender(player, nextMainHand, nextOffHand);
	}

}
