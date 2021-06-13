package data;

public class Saver extends Thread {

    @Override
    public void run() {
        try {
            while (true) {
                DataStore.getDatastore().saveJobs();
                DataStore.getDatastore().saveUsers();
                Thread.sleep(15 * 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
