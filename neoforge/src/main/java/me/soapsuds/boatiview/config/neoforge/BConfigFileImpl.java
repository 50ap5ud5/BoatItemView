package me.soapsuds.boatiview.config.neoforge;

import me.soapsuds.boatiview.config.BConfigFile;
import me.soapsuds.boatiview.config.ClientConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class BConfigFileImpl extends BConfigFile {

	public static ClientConfigImpl CLIENT_CONFIG;
	public static ModConfigSpec CLIENT_SPEC;

	public static Pair<ClientConfigImpl, ModConfigSpec> CONFIG_PAIR;

	static {
		Pair<ClientConfigImpl, ModConfigSpec> specClientPair = new ModConfigSpec.Builder().configure(ClientConfigImpl::new);
		CONFIG_PAIR = specClientPair;
		CLIENT_SPEC = specClientPair.getRight();
		CLIENT_CONFIG = specClientPair.getLeft();
	}

	//Neoforge implementation of method in common module
	public static ClientConfig getClientConfig(){
		return CLIENT_CONFIG;
	}

	@Override
	public ClientConfig clientConfig() {
		return getClientConfig();
	}
}