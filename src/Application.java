import customs.OutputMessageTypes;
import customs.PromoteUserInput;
import customs.ShowOptions;
import functions.GetWebsiteNavigationLinks;
import utils.MessageHandler;

import java.io.IOException;

public class Application {
    private static int option;
    private static ShowOptions ChooseOptions = new ShowOptions();
    private static GetWebsiteNavigationLinks getUrl = new GetWebsiteNavigationLinks();

    public static int doYouWantContinue() {
        try {
            System.out.println("Do you want to extract another website?:");
            System.out.println("\t1. Yes");
            System.out.println("\t0. No");
            PromoteUserInput promoteInput = new PromoteUserInput();
            int promotevalue = promoteInput.promoteUserInt("Enter option: ");

            switch (promotevalue) {
                case 1:
                    RepeatProcess(true);
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
        return 0;
    }

    private static int exit() {
        MessageHandler.printConsoleMessage(OutputMessageTypes.SUCCESS, "Bye!");
        return 0;
    }

    public static int RepeatProcess(Boolean status) {
        try {
            if (status) {
                option = ChooseOptions.generateOptions();

                switch (option) {
                    case 1:
                        getUrl.getWebsiteUrl();
                        doYouWantContinue();
                        break;
                    case 0:
                        exit();
                        break;
                    default:
                        MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, "Incorrect choice!");
                }
            } else {
                return 0;
            }
        } catch(Exception error) {
            MessageHandler.printConsoleMessage(OutputMessageTypes.ERROR, error.getMessage());
        }

        return 0;
    }

    public static void main(String [] args) throws IOException {
        System.out.println("\n============= WELCOME TO WEBSITE CODE CLONER =============\n");
        try {
            option = ChooseOptions.generateOptions();

            switch (option) {
                case 1:
                    getUrl.getWebsiteUrl();
                    doYouWantContinue();
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