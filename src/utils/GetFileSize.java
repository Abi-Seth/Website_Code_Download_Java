package utils;

import customs.OutputMessageTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class GetFileSize {

    public static Integer getFileSize(URL weburl) throws IOException {
        Integer count = 0;
        try {
            BufferedReader lineCounter = new BufferedReader(new InputStreamReader(weburl.openStream()));
            while( lineCounter.readLine() != null){
                count++;
            }
            lineCounter.close();
            return count;
        } catch(Exception error) {
            MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, error.getMessage());
        }
        return count;
    }
}
