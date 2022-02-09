import customs.OutputMessageTypes;
import customs.ShowOptions;
import functions.GetWebsiteNavigationLinks;
import utils.MessageHandler;

import java.io.IOException;

public class Application {
    private static int option;
    private static ShowOptions ChooseOptions = new ShowOptions();
    private static GetWebsiteNavigationLinks getUrl = new GetWebsiteNavigationLinks();

    public static int RepeatProcess(Boolean status) {
        if (status) {
            option = ChooseOptions.generateOptions();
        } else {
            return 0;
        }
        return 0;
    }

    private static int exit() {
        MessageHandler.printConsoleMessage(OutputMessageTypes.SUCCESS, "Bye!");
        return 0;
    }

    public static void main(String [] args) throws IOException {
        System.out.println("\n============= WELCOME TO WEBSITE CODE CLONER =============\n");
        try {
            RepeatProcess(true);

            switch (option) {
                case 1:
                    getUrl.getWebsiteUrl();
                    break;
                case 0:
                    exit();
                    break;
                default:
                    MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, "Incorrect choice!");
            }
        } catch (Exception error) {
            MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, error.getMessage());
        }

    }
}