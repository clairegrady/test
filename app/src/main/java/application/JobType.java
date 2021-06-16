package application;

public enum JobType {

    ACC("Accounting"), ADM("Administrative Support"), AAM("Advertising & Media"),
    BF("Banking & Finance"), CS("Customer Service"), M("Management"), COM("Community Services"),
    CON("Construction"), CST("Consultation & Strategy"), DA("Design & Architecture"),
    ET("Education & Training"), ENG("Engineering"), AGR("Agricultural"),
    GOV("Government & Defence"), MED("Medical"), HT("Hospitality & Tourism"), INS("Insurance"),
    LEG("Legal"), MAN("Manufacturing"), TL("Transport & Logistics"),
    MC("Marketing & Communications"), RE("Resources & Energy"), REP("Real Estate & Property"),
    RET("Retail"), SAL("Sales"), ST("Science & Technology"), SR("Sport & Recreation"),
    TS("Trades & Services");

    private String field;

    JobType(String field){
        this.field = field;
    }

    //Static method to return an array of values
    public static String[] getArray() {
        JobType[] constants = JobType.values();
        String[] list = new String[constants.length+1];
        list[0] = "All Job Types";
        int i = 1;
        for (JobType d : constants) {
            list[i] = d.field;
            i++;
        }
        return list;
    }
}
