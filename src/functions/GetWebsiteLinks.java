package functions;

import customs.OutputMessageTypes;
import utils.MessageHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class GetWebsiteLinks {
    public static String[] getSitNavigationLinks(String url) throws IOException {
        String[] webLinks = {};
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            Set<String> webpagelinks = new HashSet<String>();

            String link;
            while((link = reader.readLine()) != null) {
                if (link.contains("href=") && link.contains("<a") && !(link.contains("http") || link.contains("https"))) {
                    String anchor = link.split("href")[1].split("=\"")[1].split("=\"")[0] + "\n";
                    if (!(anchor.equals("./") || anchor.contains("#") || anchor.contains("mailto") || anchor.isEmpty())) {
                        webpagelinks.add(anchor);
                    }
                }
            }

            webLinks = webpagelinks.toArray(new String[webpagelinks.size()]);
            reader.close();

            if (webLinks.length == 0) {
                MessageHandler.printConsoleMessage(OutputMessageTypes.WARNING, "This website has no navigation links!");
                System.exit(1);
            }
            return webLinks;
        } catch (Exception error) {
            MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, error.getMessage());
        }
        return webLinks;
    }
}
