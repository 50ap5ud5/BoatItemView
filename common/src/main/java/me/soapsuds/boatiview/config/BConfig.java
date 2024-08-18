package me.soapsuds.boatiview.config;

import com.google.common.collect.Lists;
import me.soapsuds.boatiview.util.BConstants;
import me.soapsuds.boatiview.util.BTranslationKeys;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class BConfig {

	public static Client CLIENT;
	public static ModConfigSpec CLIENT_SPEC;

	static {
		Pair<Client, ModConfigSpec> specClientPair = new ModConfigSpec.Builder().configure(Client::new);
		CLIENT_SPEC = specClientPair.getRight();
		CLIENT = specClientPair.getLeft();
	}

	public static class Client {
		public final ModConfigSpec.BooleanValue SHOW_HANDS;
		public final ModConfigSpec.ConfigValue<List<? extends String>> WHITELISTED_ITEMS;

		public Client(ModConfigSpec.Builder builder) {
			builder.push(BConstants.CONFIG_NAME);
			SHOW_HANDS = builder.comment("Toggle whether the hand should be rendered whilst the boat is moving").translation(BTranslationKeys.CONFIG_SHOW_HANDS).define("show_hands", true);
			WHITELISTED_ITEMS = builder.comment("Items that will remain displayed in hand. Adding the character '*' after a Mod ID will include all items from the mod. E.g. 'modid:*'. If no Mod ID is specified before the '*' character, all items will be included. E.g. '*'")
					.translation(BTranslationKeys.CONFIG_WHITELIST_ITEMS)
					.defineList("whitelisted_items", Lists.newArrayList("minecraft:filled_map"), String.class::isInstance);
			builder.pop();
		}

	}

}