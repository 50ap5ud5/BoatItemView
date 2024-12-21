package me.soapsuds.boatiview.forge.platform;


import me.soapsuds.boatiview.forge.config.BConfig;
import me.soapsuds.boatiview.platform.services.IBConfigHelper;

import java.util.List;

public class ForgeConfigHelper implements IBConfigHelper {
    @Override
    public boolean showHands() {
        return BConfig.CLIENT.SHOW_HANDS.get();
    }

    @Override
    public List<? extends String> whitelistedItems() {
        return BConfig.CLIENT.WHITELISTED_ITEMS.get();
    }
}
