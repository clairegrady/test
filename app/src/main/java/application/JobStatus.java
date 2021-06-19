package application;

import data.EmploymentType;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum JobStatus {
    ACTIVE,
    DRAFT,
    CLOSED,
    NULL;

    @Override
    public String toString() {
        String stringValue = name();
        return Stream.of(stringValue.split("_"))
                .map(word -> word.charAt(0) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    public static JobStatus getEnum(String string) {
        return JobStatus.valueOf(string.toUpperCase().replace(" ", "_"));
    }
}
