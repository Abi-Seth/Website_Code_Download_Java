package functions;

import customs.OutputMessageTypes;
import customs.PromoteUserInput;
import utils.MessageHandler;
import utils.ValidateUrl;

import java.io.IOException;

public class GetWebsiteNavigationLinks {
    private static PromoteUserInput promoteUser = new PromoteUserInput();
    private static ValidateUrl validateurl = new ValidateUrl();
    private static GetWebsiteLinks getWebsiteLinks = new GetWebsiteLinks();
    private static DownloadLink download = new DownloadLink();

    public static void getWebsiteUrl() throws IOException {
        try {
            String websiteUrl = promoteUser.promoteUserString("Enter website url (format: https://domain.web): ");
            Boolean status = validateurl.validateURL(websiteUrl);

            if (status) {
                String[] webLinks = getWebsiteLinks.getSitNavigationLinks(websiteUrl);
                download.downloadSiteNavigationPages(webLinks, websiteUrl);
            }

        } catch (Exception error) {
            MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, error.getMessage());
        }

    }
}
