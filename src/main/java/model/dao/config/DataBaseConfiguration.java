package model.dao.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataBaseConfiguration {
    // todo singleton???
    private static DataBaseConfiguration instance = new DataBaseConfiguration();

    private Properties properties = loadProperties(ConfigurationKeys.PROPERTIES_PATH);

    private DataBaseConfiguration(){

    }

    public static DataBaseConfiguration getInstance(){
        return instance;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }


    private Properties loadProperties(String path){
        Properties properties = new Properties();
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path)){
            properties.load(inputStream);
        } catch (IOException e) {
            // todo add logger
            e.printStackTrace();
        }
        return properties;
    }

}
