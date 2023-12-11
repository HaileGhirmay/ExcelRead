package com.demo.ExcelProject;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsLoaderService {

    public static Properties loadProperties(String filePath) throws IOException {
        Properties properties = new Properties();
        try(InputStream propFile = new FileInputStream(filePath)){
            properties.load(propFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }
}
