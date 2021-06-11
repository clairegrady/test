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

    public void writeFile(List<T> item){

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

    public List<T> readFile(){

        List<T> list = new ArrayList<>();

        try (
                InputStream fileIs = new FileInputStream(filePath);
                ObjectInputStream objIs = new ObjectInputStream(fileIs);
                ){
            list = (List<T>) objIs.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;

    }

}