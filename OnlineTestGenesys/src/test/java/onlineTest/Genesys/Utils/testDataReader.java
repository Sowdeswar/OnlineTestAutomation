package onlineTest.Genesys.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static onlineTest.Genesys.common.Constants.TESTDATA_PATH;

public class testDataReader {
    String dataLine;

    public String getData(String fileName){
        StringBuilder stringBuilder=new StringBuilder();
        try{

            BufferedReader bufferedReader=new BufferedReader(new FileReader(TESTDATA_PATH + fileName));
while ((dataLine=bufferedReader.readLine())!=null){
    stringBuilder.append(dataLine);
}
bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
