package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileIO<T extends Storable> {

    private String filePath;

    public FileIO() {
        this.filePath = "Default";
    }

    public FileIO(String filePath) {
        this.filePath = filePath;
    }

    public void writeFile(List<T> data) {
        try (
                FileOutputStream fout = new FileOutputStream(filePath, true);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
        ){
            oos.writeObject(data);
            oos.writeObject(null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<T> readFile() {

        List<T> destinationList = new ArrayList<>();
        ObjectInputStream reader = null;
//        TODO: write try block with resources style
        try {
            FileInputStream file = new FileInputStream(filePath);
            reader = new ObjectInputStream(file);

            while (true) {
                try {
                    Object obj = reader.readObject();
                    if (obj == null) {
                        break;
                    }
                    destinationList = (List<T>) obj;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        return destinationList;

    }

}