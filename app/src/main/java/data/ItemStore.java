package data;


import java.util.*;

public class ItemStore<T extends Storable> {

    private final String filePath;
    private final Map<String, T> items;
    private final FileIO<T> fileIO;

    public ItemStore() {
        this.filePath = "Unknown";
        this.items = new HashMap<>();
        this.fileIO = new FileIO<>();
    }

    public ItemStore(String filePath) {
        this.filePath = filePath;
        this.items = new HashMap<>();
        this.fileIO = new FileIO<>(filePath);
        loadData();
    }

    List<T> getAll() {
        return new ArrayList<>(items.values());
    }

    Optional<T> getByUniqueId(String uniqueId) {
        return Optional.ofNullable(items.get(uniqueId));
    }

    public void loadData() {
        List<T> list = this.fileIO.readFile();

        for (T item : list) {
            items.put(item.getUniqueId(), item);
        }

    }

    public void saveData() {
        this.fileIO.writeFile(new ArrayList<>(this.items.values()));
    }

    void updateItem(T item) {
        items.put(item.getUniqueId(), item);
    }

    <S extends T> Optional<S> getSubclassById(String id, Class<S> c) {

        T item = items.get(id);

        if (item != null) {
            return Optional.ofNullable((S) item);
        }

        return Optional.empty();
    }
}
