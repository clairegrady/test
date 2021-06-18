package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileIO<T extends Storable> {

    private String filePath;

    public FileIO() {
        this.filePath = null;
    }

    public FileIO(String filePath) {
        this.filePath = filePath;
    }

    public void checkFileExists() {
        try {
            File myFile = new File(filePath);

            if (myFile.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(List<T> item) {

        checkFileExists();

        try (
                OutputStream ops = new FileOutputStream(filePath, false);
                ObjectOutputStream objOps = new ObjectOutputStream(ops);
        ) {
            objOps.writeObject(item);
            objOps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public List<T> readFile() {

        checkFileExists();

        List<T> list = new ArrayList<>();

        File f = new File(filePath);
        if (!f.exists()) {
            System.out.println("file doesnt exist");
            try {
                f.createNewFile();
            } catch (Exception e) {
                System.out.println("Creating file exception " + e);
            }
        }

        try (
                InputStream fileIs = new FileInputStream(filePath);
                ObjectInputStream objIs = new ObjectInputStream(fileIs);
        ) {
            list = (List<T>) objIs.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;

    }

}