package utils;

import customs.OutputMessageTypes;

public class MessageHandler {
    public static void printConsoleMessage(OutputMessageTypes msgType, String msg) {
        if (msgType == OutputMessageTypes.ERROR) {
            System.out.println(ConsoleColorValues.getRED()+msg+ConsoleColorValues.getRESET());
        } else if (msgType == OutputMessageTypes.SUCCESS) {
            System.out.println(ConsoleColorValues.getGREEN()+msg+ConsoleColorValues.getRESET());
        } else if (msgType == OutputMessageTypes.WARNING) {
            System.out.println(ConsoleColorValues.getYELLOW()+msg+ConsoleColorValues.getRESET());
        } else if (msgType == OutputMessageTypes.ACTION) {
            System.out.println(ConsoleColorValues.getBLUE()+msg+ConsoleColorValues.getRESET());
        } else {
            System.out.println("Something went wrong getting console colors!");
        }
    }
}
