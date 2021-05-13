package me.soapsuds.boatiview.compat;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;

@Environment(EnvType.CLIENT)
public class ModMenuConfig implements ModMenuApi{
	
	private static ConfigScreenFactory<?> CONFIG = FabricLoader.getInstance().isModLoaded("cloth-config2")
		    ? new BClothConfig()
		    : parent -> null;
	
	@Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return CONFIG;
    }
	
}
