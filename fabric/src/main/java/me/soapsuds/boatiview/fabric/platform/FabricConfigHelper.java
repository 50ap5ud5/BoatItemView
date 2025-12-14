package me.soapsuds.boatiview.fabric.platform;


import me.soapsuds.boatiview.fabric.BoatItemViewImpl;
import me.soapsuds.boatiview.fabric.config.BConfig;
import me.soapsuds.boatiview.platform.services.IBConfigHelper;

import java.util.List;

public class FabricConfigHelper implements IBConfigHelper {
    @Override
    public boolean showHands() {
        BConfig config = BoatItemViewImpl.CONFIG.getConfig();
        return config.clientConfig.show_hands;
    }

    @Override
    public List<? extends String> whitelistedItems() {
        BConfig config = BoatItemViewImpl.CONFIG.getConfig();
        return config.clientConfig.whitelisted_items;
    }
}
