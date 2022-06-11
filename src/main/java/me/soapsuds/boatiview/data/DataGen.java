package me.soapsuds.boatiview.data;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.SharedConstants;
import net.minecraft.WorldVersion;
import net.minecraft.data.DataGenerator;


public class DataGen {
	
	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	
	public static void main(String[] strings) throws IOException {
		Path path = Paths.get("./src/main/generated");
		Collection<Path> paths = Lists.newArrayList(path);
		DataGenerator dataGen = createDataGenerators(path, paths, SharedConstants.getCurrentVersion());
		dataGen.run();
	}
	
	public static DataGenerator createDataGenerators(Path path, Collection<Path> collection, WorldVersion worldVersion) throws IOException{
		DataGenerator generator = new DataGenerator(path, collection, worldVersion, true);
		
		generator.addProvider(true, new BLangGen(generator));
		
		return generator;
	}

}
