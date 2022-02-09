package utils;

public class ConsoleColorValues {
    private static String RED = "\u001B[31m";
    private static String GREEN = "\u001B[32m";
    private static String YELLOW = "\u001B[33m";
//    private static String BLUE = "\u001B[34;9m";
    private static String BLUE = "\u001B[34m";
    private static String RESET = "\u001B[0m";

    public static String getBLUE() {
        return BLUE;
    }

    public static String getRED() {
        return RED;
    }

    public static String getGREEN() {
        return GREEN;
    }

    public static String getYELLOW() {
        return YELLOW;
    }

    public static String getRESET() {
        return RESET;
    }
}
