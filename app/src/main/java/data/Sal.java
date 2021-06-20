package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Sal {

    ALL_SALARIES(0) {
        @Override
        public String toString() {
            return "All Salaries";
        }
    },
    SELECT_SALARY(0) {
        @Override
        public String toString() {
            return "Select";
        }
    },
    FORTY(40),
    FIFTY(50),
    SIXTY(60),
    SEVENTY(70),
    EIGHTY(80),
    NINETY(90),
    HUNDRED(100),
    ONETWENTY(120),
    ONEFIFTY(150),
    TWOHUNDRED(200);

    private final int displayValue;

    Sal(int displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return displayValue + "K+";
    }

    public int getValue() {
        return displayValue;
    }

    public int getDollarValue() {
        return displayValue * 1000;
    }

    public static Sal[] getValuesExcept(Sal salary) {
        List<Sal> list = new ArrayList<>(Arrays.asList(values()));

        list.remove(salary);

        return list.toArray(new Sal[0]);
    }

    public static Sal[] getSearchFormSalaries() {
        return getValuesExcept(Sal.SELECT_SALARY);
    }

    public static Sal[] getCreateFormSalaries() {
        return getValuesExcept(Sal.ALL_SALARIES);
    }

    public static Sal getEnum(String string) {
        if (string.equalsIgnoreCase("all salaries")) {
            return Sal.ALL_SALARIES;
        }
        for (Sal sal : values()) {
            if (sal.getValue() == Integer.parseInt(string.substring(0, string.length()-2))){
                return sal;
            }
        }
        return null;
    }





}
