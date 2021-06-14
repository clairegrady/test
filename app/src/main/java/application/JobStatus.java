package application;

public enum JobStatus {
    ACTIVE,
    DRAFT,
    CLOSED,
    NULL;

    @Override
    public String toString() {
        String name = this.name().toLowerCase();

        return name.substring(0,1).toUpperCase() + name.substring(1);

    }
}
