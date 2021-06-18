package data;

public enum Location {

    ACT, NSW, NT, QLD, SA, TAS, VIC, WA;

    //Static method to return an array of values
    public static String[] getArray() {
        Location[] constants = Location.values();
        String[] list = new String[constants.length + 1];
        list[0] = "All Locations";
        int i = 1;
        for (Location d : constants) {
            list[i] = d.toString();
            i++;
        }
        return list;
    }

    public static String[] getCreateArray() {
        Location[] constants = Location.values();
        String[] list = new String[constants.length + 1];
        list[0] = "-Select location";
        int i = 1;
        for (Location d : constants) {
            list[i] = d.toString();
            i++;
        }
        return list;
    }
}
