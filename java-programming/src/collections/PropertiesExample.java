package collections;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesExample {
	static {
		//@ class will load right away because its a static
		System.out.println("Class Loading");
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		// moved application.properties to resources folder so it cant read it anymore, as FileReader only reads local area
		// props.load(new FileReader("application.properties")); 
		InputStream in = ClassLoader.getSystemResourceAsStream("application.properties");
		props.load(in);
		System.out.println(props.get("database.username")); 
	}

}
