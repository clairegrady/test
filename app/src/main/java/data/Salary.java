package data;

public enum Salary {

    FORTY("40K+"), FIFTY("50K+"), SIXTY("60K+"), EIGHTY("80K+"), NINETY("70K+"), HUNDRED("100K+"),
    ONETWENTY("120K+"), ONEFIFTY("150K+"), TWOHUNDRED("200K+");

    private String amount;

    Salary(String amount){
        this.amount = amount;
    }

    //Static method to return an array of values
    public static String[] getArray() {
        Salary[] constants = Salary.values();
        String[] list = new String[constants.length+1];
        list[0] = "All Salary";
        int i = 1;
        for (Salary d : constants) {
            list[i] = d.amount;
            i++;
        }
        return list;
    }
}
