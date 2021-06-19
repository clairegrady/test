package utility;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringFormat {

    public static String formatEnumStrings(String string) {
        return Stream.of(string.split("_"))
                .map(word -> word.charAt(0) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
