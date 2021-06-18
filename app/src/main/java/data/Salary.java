package data;

public enum Salary {

    ZERO("0K"), FORTY("40K"), FIFTY("50K"), SIXTY("60K"), SEVENTY("70K"), EIGHTY("80K"),
    NINETY("90K"), HUNDRED("100K"), ONETWENTY("120K"), ONEFIFTY("150K"),
    TWOHUNDRED("200K"), ZEROPH("0 p/h"), FIFTEENPH("15 p/h"), TWENTYPH("20 p/h"),
    TWENTYFIVEPH("25 p/h"), THIRTYPH("30 p/h"), THIRTYFIVEPH("35 p/h"), FORTYPH("40 p/h"),
    FIFTYPH("50 p/h"), SIXTYPH("60 p/h"), SEVENTYFIVEPH("75 p/h"), HUNDREDPH("100 p/h");

    private final String amount;

    Salary(String amount) {
        this.amount = amount;
    }

    //Static method to return an array of values
    public static String[] getSalaryArray() {
        Salary[] constants = Salary.values();
        String[] list = new String[12];
        list[0] = "All Salary";
        int i = 1;
        for (Salary d : constants) {
            if (d.ordinal() <= 10) {
                list[i] = d.amount + "+";
                i++;
            }
        }
        return list;
    }

    public static String[] getCreateSalaryArray() {
        Salary[] constants = Salary.values();
        String[] list = new String[12];
        list[0] = "-Select";
        int i = 1;
        for (Salary d : constants) {
            if (d.ordinal() <= 10) {
                list[i] = d.amount;
                i++;
            }
        }
        return list;
    }

    public static String[] getPerHourArray() {
        Salary[] constants = Salary.values();
        String[] list = new String[11];
        int i = 0;
        for (Salary d : constants) {
            if (d.ordinal() > 10) {
                list[i] = d.amount + "+";
                i++;
            }
        }
        return list;
    }

    public static String[] getCreatePerHourArray() {
        Salary[] constants = Salary.values();
        String[] list = new String[12];
        list[0] = "-Select";
        int i = 1;
        for (Salary d : constants) {
            if (d.ordinal() > 10) {
                list[i] = d.amount;
                i++;
            }
        }
        return list;
    }
}
