package data;

public enum DataType {
    USER("app/src/main/java/data/users.dat"),
    JOB("app/src/main/java/data/jobs.dat");

    private String filePath;

    DataType(String filePath){
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
