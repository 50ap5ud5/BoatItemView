package me.soapsuds.boatiview.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import me.soapsuds.boatiview.client.ClientHandler;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.FirstPersonRenderer;
import net.minecraft.item.ItemStack;

@Mixin(FirstPersonRenderer.class)
public class FirstPersonRendererMixin {
	
	@Inject(method = "Lnet/minecraft/client/renderer/FirstPersonRenderer;tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/player/ClientPlayerEntity;isHandsBusy()Z"), locals = LocalCapture.CAPTURE_FAILSOFT)
	public void modifyHandRender(CallbackInfo info, ClientPlayerEntity clientplayerentity, ItemStack itemstack, ItemStack itemstack1) {
		ClientHandler.modifyHandRender(clientplayerentity, itemstack, itemstack1);
	}

}
