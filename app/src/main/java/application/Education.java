package application;

public enum Education {

    NAP("Not Applicable"), SEC("Secondary"), UCD("Undergraduate Cert/Diploma"), BAC("Bachelor"), PCD("Post-Graduate Cert/Diploma"), MAS("Masters"), DOC("Doctorate");

    private String edType;

    Education(String edType){
        this.edType = edType;
    }

    //Static method to return an array of values
    public static String[] getCreateArray() {
        Education[] constants = Education.values();
        String[] list = new String[constants.length+1];
        list[0] = "-Select highest level of education";
        int i = 1;
        for (Education d : constants) {
            list[i] = d.edType;
            i++;
        }
        return list;
    }
}
