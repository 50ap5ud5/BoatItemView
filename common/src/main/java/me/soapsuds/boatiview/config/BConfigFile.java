package me.soapsuds.boatiview.config;

import dev.architectury.injectables.annotations.ExpectPlatform;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.soapsuds.boatiview.BoatItemView;
import me.soapsuds.boatiview.util.BConstants;

@Config(name = BoatItemView.MODID)
public class BConfigFile extends PartitioningSerializer.GlobalData implements BConfig{

    @ConfigEntry.Category(BConstants.CONFIG_NAME)
    @ConfigEntry.Gui.TransitiveObject
    private ClientConfig clientConfig = new ClientConfig();

//    @ExpectPlatform
//    public static ClientConfig getClientConfig(){
//        throw new AssertionError();
//    }

    @Override
    public ClientConfig clientConfig() {
        return clientConfig;
    }
}
