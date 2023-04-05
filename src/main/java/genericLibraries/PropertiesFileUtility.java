package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains reusable methods for the actions
 * performed on properties file
 * @author Welcome
 *
 */
public class PropertiesFileUtility {
	private Properties property;
	/**
	 * 
	 * @param filePath
	 */
	public void propertyConfig(String filePath) {
		FileInputStream fis =null;
		try {
			 fis=new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties property=new Properties();
		try {
			property.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to fetch the value from
	 * properties file based on key
	 * @param key
	 * @return
	 */
	public String fetchProperty(String key) {
		return property.getProperty(key);
	}
	/**
	 * 
	 * @param key
	 * @param value
	 * @param filepath
	 * @param message
	 */
	public void setDataToProperties(String key,String value,String filepath,String message)
	{
		property.put(key,value);
	}
}
