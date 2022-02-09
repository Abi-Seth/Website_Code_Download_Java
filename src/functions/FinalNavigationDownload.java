package functions;

import customs.OutputMessageTypes;
import utils.CreateFile;
import utils.MessageHandler;

import java.io.*;
import java.net.URL;

public class FinalNavigationDownload {
    private static CreateFile createnewfile = new CreateFile();

    public static void DownloadANavigationLink(String filename, Integer fileSize, String baseUrl) throws IOException {
        try {
            filename = filename.split("\"")[0];
            BufferedReader webReader = new BufferedReader(new InputStreamReader(new URL(baseUrl+"/"+filename).openStream()));
            filename = filename.contains("?") ? filename.split("\\?")[0] : filename;
            filename = filename.split("\\.")[0].length() == 0 ? "home.html" : filename.split("\\.")[0] + ".html";

            createnewfile.createAFile(filename, baseUrl);

            BufferedWriter writer = new BufferedWriter(new FileWriter("Storage/"+baseUrl.split("//")[1]+filename));
            String line;
            Integer currentLineCount = 0;
            Double percentage = 0.0;

            while((line = webReader.readLine()) != null){
                currentLineCount++;
                percentage = ((double)currentLineCount/(double)fileSize) * 100.0;
                MessageHandler.printConsoleMessage(OutputMessageTypes.ACTION,"Downloading "+Math.round(percentage)+"%\r");
                writer.write(line+"\n");
            }

            System.out.println();

            webReader.close();
            writer.close();

            MessageHandler.printConsoleMessage(OutputMessageTypes.SUCCESS,"Downloaded "+filename.replace("./","") +" successfully");
        }
        catch(Exception error){
            MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, error.getMessage());
        }
    }

}
