package functions;

import customs.OutputMessageTypes;
import utils.FilterOutUnwantedKeyword;
import utils.GetFileSize;
import utils.MessageHandler;
import java.net.URL;

import java.io.IOException;

public class DownloadLink {
    private static FilterOutUnwantedKeyword filterout = new FilterOutUnwantedKeyword();
    private static GetFileSize getfilesize = new GetFileSize();
    private static FinalNavigationDownload finaldownload = new FinalNavigationDownload();
    private static StoreAllClonedSites storeDataInDb = new StoreAllClonedSites();

    public static void downloadSiteNavigationPages(String[] webLinks, String baseUrl) throws IOException {
        try {
            for (int i = 0; i < webLinks.length; i++) {
                webLinks[i] = filterout.filterKOutUnwantedKeyword(webLinks[i]);

                MessageHandler.printConsoleMessage(OutputMessageTypes.ACTION,"Downloading "+webLinks[i].split("\"")[0].replace("./","")+" . . .");
                MessageHandler.printConsoleMessage(OutputMessageTypes.ACTION,"Downloading 0%\r");

                Integer filesize = getfilesize.getFileSize(new URL(baseUrl+"/"+webLinks[i].split("\"")[0]));
                finaldownload.DownloadANavigationLink(webLinks[i], filesize, baseUrl);
                try {
                    storeDataInDb.storeIntoDatabase(baseUrl);
                } catch (Exception error) {
                    MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, error.getMessage());
                }
            }

            MessageHandler.printConsoleMessage(OutputMessageTypes.SUCCESS, "### Download complete ###");

        } catch (Exception error) {
            MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, error.getMessage());
        }
    }
}
