package me.soapsuds.boatiview.config.neoforge;

import com.google.common.collect.Lists;
import me.soapsuds.boatiview.config.ClientConfig;
import me.soapsuds.boatiview.util.BConstants;
import me.soapsuds.boatiview.util.BTranslationKeys;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class ClientConfigImpl extends ClientConfig {

    private final ModConfigSpec.BooleanValue SHOW_HANDS;
    private final ModConfigSpec.ConfigValue<List<? extends String>> WHITELISTED_ITEMS;

    public ClientConfigImpl(ModConfigSpec.Builder builder) {
        builder.push(BConstants.CONFIG_NAME);
        SHOW_HANDS = builder.comment("Toggle whether the hand should be rendered whilst the boat is moving").translation(BTranslationKeys.CONFIG_SHOW_HANDS).define("show_hands", true);
        WHITELISTED_ITEMS = builder.comment("List of items that will make the hand display when a boat is moving\nSeperate every entry except the last one with commas\nTo include all items for a particular modid use the wildcard character '*'. E.g. modid:*")
                .translation(BTranslationKeys.CONFIG_WHITELIST_ITEMS)
                .defineList("whitelisted_items", Lists.newArrayList("minecraft:filled_map"), String.class::isInstance);
        builder.pop();
    }

    @Override
    public List<? extends String> itemsToShowInMovingBoat() {
        return this.WHITELISTED_ITEMS.get();
    }

    @Override
    public boolean showHandsInMovingBoat() {
        return this.SHOW_HANDS.getAsBoolean();
    }


}
