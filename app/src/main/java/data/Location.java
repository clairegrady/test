package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Location {
    ALL_LOCATIONS,
    SELECT_LOCATIONS,
    ADELAIDE,
    ALBURY_WODONGA,
    BALLARAT,
    BENDIGO,
    BRISBANE,
    BUNBURY,
    CAIRNS,
    CANBERRA,
    CENTRAL_COAST,
    DARWIN,
    GEELONG,
    GOLD_COAST,
    HOBART,
    LAUNCESTON,
    MACKAY,
    MELBOURNE,
    MELTON,
    NEWCASTLE,
    PERTH,
    ROCKHAMPTON,
    SUNSHINE_COAST,
    SYDNEY,
    TOOWOOMBA,
    TOWNSVILLE,
    WOLLONGONG;

    @Override
    public String toString() {
        String stringValue = name();
        return Stream.of(stringValue.split("_"))
                .map(word -> word.charAt(0) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    public static Location[] getValuesExcept(Location location) {
        List<Location> list = new ArrayList<>(Arrays.asList(values()));

        list.remove(location);

        return list.toArray(new Location[0]);
    }

    public static Location[] getSearchFormLocations() {
        return getValuesExcept(Location.SELECT_LOCATIONS);
    }

    public static Location[] getCreateFormLocations() {
        return getValuesExcept(Location.ALL_LOCATIONS);
    }

    public static Location getEnum(String string) {
        return Location.valueOf(string.toUpperCase().replace(" ", "_"));
    }

}
