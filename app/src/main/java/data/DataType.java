package data;

import java.io.File;
import java.net.URISyntaxException;

public enum DataType {
    USER("users.txt"),
    JOB("jobs.txt");

    private final String filePath;

    DataType(String fileName) {

        String dir = "";

        try {
            dir = new File(DataType.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
        } catch (URISyntaxException ex) {
            System.out.println("Could not locate data files.");
        }

        this.filePath = dir + File.separator + fileName;

    }

    public String getFilePath() {
        return filePath;
    }
}
