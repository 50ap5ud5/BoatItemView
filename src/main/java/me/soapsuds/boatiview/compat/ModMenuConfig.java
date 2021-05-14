package me.soapsuds.boatiview.compat;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import me.shedaniel.autoconfig.AutoConfig;
import me.soapsuds.boatiview.config.BConfig;
import me.soapsuds.boatiview.util.BConstants;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;

@Environment(EnvType.CLIENT)
public class ModMenuConfig implements ModMenuApi{

	@Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> FabricLoader.getInstance().isModLoaded(BConstants.CLOTH_CONFIG_MODID)
    		    ? AutoConfig.getConfigScreen(BConfig.class, parent).get()
    				    : null;
    }
	
}
