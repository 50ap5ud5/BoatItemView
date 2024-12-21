package me.soapsuds.boatiview.platform.services;

import java.util.List;

public interface IBConfigHelper {

    boolean showHands();
    List<? extends String> whitelistedItems();
}
