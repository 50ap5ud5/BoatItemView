package me.soapsuds.boatiview.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import me.soapsuds.boatiview.client.ClientHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.item.ItemStack;

@Mixin(HeldItemRenderer.class)
public class FirstPersonRendererMixin {
	
	@Inject(method = "Lnet/minecraft/client/render/item/HeldItemRenderer;updateHeldItems()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;isRiding()Z"), locals = LocalCapture.CAPTURE_FAILSOFT)
	public void modifyHandRender(CallbackInfo info, ClientPlayerEntity clientplayerentity, ItemStack itemstack, ItemStack itemstack1) {
		ClientHandler.modifyHandRender(clientplayerentity, itemstack, itemstack1);
	}

}
