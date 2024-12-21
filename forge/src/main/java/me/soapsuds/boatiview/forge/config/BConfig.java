package me.soapsuds.boatiview.forge.config;

import com.google.common.collect.Lists;
import me.soapsuds.boatiview.util.BConstants;
import me.soapsuds.boatiview.util.BTranslationKeys;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class BConfig {

	public static Client CLIENT;
	public static ForgeConfigSpec CLIENT_SPEC;

	static {
		Pair<Client, ForgeConfigSpec> specClientPair = new ForgeConfigSpec.Builder().configure(Client::new);
		CLIENT_SPEC = specClientPair.getRight();
		CLIENT = specClientPair.getLeft();
	}

	public static class Client {
		public final ForgeConfigSpec.BooleanValue SHOW_HANDS;
		public final ForgeConfigSpec.ConfigValue<List<? extends String>> WHITELISTED_ITEMS;

		public Client(ForgeConfigSpec.Builder builder) {
			builder.push(BConstants.CONFIG_NAME);
			SHOW_HANDS = builder.comment("Toggle whether the item held in hand should be rendered whilst the boat is moving").translation(BTranslationKeys.CONFIG_SHOW_HANDS).define("show_hands", true);
			WHITELISTED_ITEMS = builder.comment("Items that will remain displayed in hand. Adding the character '*' after a Mod ID will include all items from the mod. E.g. 'modid:*'. If no Mod ID is specified before the '*' character, all items will be included. E.g. '*'")
					.translation(BTranslationKeys.CONFIG_WHITELIST_ITEMS)
					.defineList("whitelisted_items", Lists.newArrayList("minecraft:filled_map"), String.class::isInstance);
			builder.pop();
		}

	}

}