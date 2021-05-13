package me.soapsuds.boatiview.data;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.data.DataGenerator;


public class DataGen {
	
	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	
	public static void main(String[] strings) throws IOException {
		
	}
	
	public static void onDataGen(Path path, Collection<Path> collection) {
		DataGenerator generator = new DataGenerator(path, collection);

		generator.install(new BLangGen(generator));

	}

}
