package me.soapsuds.boatiview.fabric.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfigClient;
import me.soapsuds.boatiview.util.BConstants;
import net.fabricmc.loader.api.FabricLoader;

public class ConfigModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> FabricLoader.getInstance().isModLoaded(BConstants.CLOTH_CONFIG_MODID) ? AutoConfigClient.getConfigScreen(BConfig.class, parent).get() : null;
    }
}