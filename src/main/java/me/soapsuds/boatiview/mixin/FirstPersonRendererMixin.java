package me.soapsuds.boatiview.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import me.soapsuds.boatiview.client.ClientHandler;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.item.ItemStack;

@Mixin(ItemInHandRenderer.class)
public class FirstPersonRendererMixin {
	
	@Inject(method = "Lnet/minecraft/client/renderer/ItemInHandRenderer;tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isHandsBusy()Z"), locals = LocalCapture.CAPTURE_FAILSOFT)
	public void modifyHandRender(CallbackInfo info, LocalPlayer clientplayerentity, ItemStack itemstack, ItemStack itemstack1) {
		ClientHandler.modifyHandRender(clientplayerentity, itemstack, itemstack1);
	}

}
