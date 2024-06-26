package onlineTest.Genesys.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static String getProperty(String fileName,String Key){
        Properties prop = null;
        try{
              prop = new Properties();
           prop.load(new FileInputStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
     return prop.getProperty(Key);
    }
}
