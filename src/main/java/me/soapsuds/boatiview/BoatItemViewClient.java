package me.soapsuds.boatiview;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.gui.registry.GuiRegistry;
import me.soapsuds.boatiview.config.BConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BoatItemViewClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // how to get the gui registry for custom gui handlers
    	GuiRegistry registry = AutoConfig.getGuiRegistry(BConfig.class);
    }
}