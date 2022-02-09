package utils;

import customs.OutputMessageTypes;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void createAFile(String filename, String baseUrl) throws IOException {
        try{
            filename = filename.contains("?") ? filename.split("\\?")[0] : filename;
            File file = new File("Storage/"+baseUrl.split("//")[1]+filename);
            if(!file.exists()){
                if(file.getParentFile() != null){
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
        }
        catch(Exception error){
            MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, error.getMessage());
        }
    }
}
