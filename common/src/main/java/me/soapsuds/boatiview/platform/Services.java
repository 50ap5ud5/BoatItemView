package me.soapsuds.boatiview.platform;

import me.soapsuds.boatiview.BoatItemView;
import me.soapsuds.boatiview.platform.services.IBConfigHelper;

import java.util.ServiceLoader;

public class Services {

    public static final IBConfigHelper CONFIG_HELPER = load(IBConfigHelper.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        BoatItemView.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}
