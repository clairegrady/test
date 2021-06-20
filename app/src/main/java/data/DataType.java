package data;

public enum DataType {
    USER("src/main/resources/users.dat"),
    JOB("src/main/resources/jobs.dat");

    private String filePath;

    DataType(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
