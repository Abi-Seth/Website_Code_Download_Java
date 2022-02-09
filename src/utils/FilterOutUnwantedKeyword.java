package utils;

public class FilterOutUnwantedKeyword {
    public static String filterKOutUnwantedKeyword(String value) {
        value = value.replace("../", "");
        value = value.replace("./", "");
        value = value.replace("\n", "");
        return value;
    }
}
