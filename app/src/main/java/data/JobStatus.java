package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public static JobStatus[] getValuesExcept(JobStatus jobStatus) {
        List<JobStatus> list = new ArrayList<>(Arrays.asList(values()));

        list.remove(jobStatus);

        return list.toArray(new JobStatus[0]);
    }

    public static JobStatus[] getSearchFormEmpoymentType() {
        return getValuesExcept(JobStatus.NULL);
    }

    public static JobStatus[] getCreateFormEmploymentType() {
        return getValuesExcept(JobStatus.NULL);
    }

    public static int getIndexOfValue(String value) {

        for (int i = 0; i < values().length; i++) {
            if (values()[i].toString().equals(value)) {
                return i;
            }
        }

        return 0;
    }

    public static JobStatus getEnum(String string) {
        return JobStatus.valueOf(string.toUpperCase().replace(" ", "_"));
    }
}
