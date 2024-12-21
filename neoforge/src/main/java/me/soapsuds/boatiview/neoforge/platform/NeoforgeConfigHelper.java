package me.soapsuds.boatiview.neoforge.platform;


import me.soapsuds.boatiview.neoforge.config.BConfig;
import me.soapsuds.boatiview.platform.services.IBConfigHelper;

import java.util.List;

public class NeoforgeConfigHelper implements IBConfigHelper {
    @Override
    public boolean showHands() {
        return BConfig.CLIENT.SHOW_HANDS.getAsBoolean();
    }

    @Override
    public List<? extends String> whitelistedItems() {
        return BConfig.CLIENT.WHITELISTED_ITEMS.get();
    }
}
