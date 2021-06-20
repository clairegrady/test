package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MatchScore {
    ALL_MATCHES(0) {
        @Override
        public String toString() {
            return "All Matches";
        }
    },
    FIFTY(50),
    SIXTY(60),
    SEVENTY(70),
    EIGHTY(80),
    NINETY(90);

    private final int displayValue;

    MatchScore(int displayValue) {
            this.displayValue = displayValue;
        }

    @Override
    public String toString() {
        return displayValue + "+";
    }

    public int getValue() {
        return displayValue;
    }

    public static MatchScore[] getValuesExcept(MatchScore matchScore) {
        List<MatchScore> list = new ArrayList<>(Arrays.asList(values()));

        list.remove(matchScore);

        return list.toArray(new MatchScore[0]);
    }

    public static MatchScore[] getCreateFormSalaries() {
        return getValuesExcept(MatchScore.ALL_MATCHES);
    }

    public static MatchScore getEnum(String string) {
        if (string.equalsIgnoreCase("all matches")) {
            return MatchScore.ALL_MATCHES;
        }
        for (MatchScore sal : values()) {
            if (sal.getValue() == Integer.parseInt(string.substring(0, string.length()-1))){
                return sal;
            }
        }
        return null;
    }





}
