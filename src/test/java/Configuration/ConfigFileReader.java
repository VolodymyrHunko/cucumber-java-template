package Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    Properties properties;
    // constructor...
    public ConfigFileReader()  {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/Configuration/Configuration.properties"))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found on this path.");
        }
    }

    public long getImplicitlyWait(){
        String implicitlyWait = properties.getProperty("ImplicitWaitTime");
        if(implicitlyWait != null) {
            return Long.parseLong(implicitlyWait);
        }else{
            throw new RuntimeException("implicitlyWait not specified in config file");
        }
    }

    public String getAppURL(){
        String url = properties.getProperty("url");
        if(url != null){
            return url;
        }else {
            throw new RuntimeException("URL not specified in config file.");
        }
    }
}
