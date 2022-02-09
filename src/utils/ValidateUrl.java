package utils;

import customs.OutputMessageTypes;

import java.io.IOException;
import java.net.URL;

public class ValidateUrl {
    private static MessageHandler printConsoleMessage = new MessageHandler();

    public static Boolean validateURL(String url) throws IOException {
        try {
            new URL(url).openStream().close();
            return true;
        } catch (Exception error) {
            MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, error.getMessage());
        }
        return false;
    }
}
