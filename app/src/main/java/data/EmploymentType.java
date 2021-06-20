package data;

import utility.StringFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EmploymentType implements Serializable {
    FULL_TIME,
    PART_TIME,
    CONTRACT,
    CASUAL,
    NULL;

    @Override
    public String toString() {
        return StringFormat.formatEnumStrings(name());
    }

    public static EmploymentType[] getValuesExcept(EmploymentType location) {
        List<EmploymentType> list = new ArrayList<>(Arrays.asList(values()));

        list.remove(location);

        return list.toArray(new EmploymentType[0]);
    }

    public static EmploymentType[] getSearchFormEmpoymentType() {
        return getValuesExcept(EmploymentType.NULL);
    }

    public static EmploymentType[] getCreateFormEmploymentType() {
        return getValuesExcept(EmploymentType.NULL);
    }

    public static EmploymentType getEnum(String string) {
        return EmploymentType.valueOf(string.toUpperCase().replace(" ", "_"));
    }

}
