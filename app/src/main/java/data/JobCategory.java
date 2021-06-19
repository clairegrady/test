package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum JobCategory {
    ALL_CATEGORIES,
    SELECT_CATEGORIES,
    ACCOUNTING,
    ADMINISTRATIVE_SUPPORT,
    ADVERTISING_AND_MEDIA,
    AGRICULTURAL,
    BANKING_AND_FINANCE,
    COMMUNITY_SERVICES,
    CONSTRUCTION,
    CONSULTATION_AND_STRATEGY,
    CUSTOMER_SERVICE,
    DESIGN_AND_ARCHITECTURE,
    EDUCATION_AND_TRAINING,
    ENGINEERING,
    GOVERNMENT_AND_DEFENCE,
    HOSPITALITY_AND_TOURISM,
    INSURANCE,
    LEGAL,
    MANAGEMENT,
    MANUFACTURING,
    MARKETING_AND_COMMUNICATION,
    MEDICAL,
    REAL_ESTATE_AND_PROPERTY,
    RESOURCES_AND_ENERGY,
    RETAIL,
    SALES,
    SCIENCE_AND_TECHNOLOGY,
    SPORT_AND_RECREATION,
    TRADE_AND_SERVICES,
    TRANSPORT_AND_LOGISTICS;

    @Override
    public String toString() {
        String stringValue = name();
        return Stream.of(stringValue.split("_"))
                .map(word -> word.replace("AND", "&"))
                .map(word -> word.charAt(0) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    public static JobCategory[] getValuesExcept(JobCategory category) {
        List<JobCategory> list = new ArrayList<>(Arrays.asList(values()));

        list.remove(category);

        return list.toArray(new JobCategory[0]);
    }

    public static JobCategory[] getSearchFormCategories() {
        return getValuesExcept(JobCategory.SELECT_CATEGORIES);
    }

    public static JobCategory[] getCreateFormCategories() {
        return getValuesExcept(JobCategory.ALL_CATEGORIES);
    }


    public static JobCategory getEnum(String string) {
        return JobCategory.valueOf(string.toUpperCase().replace("&","AND").replace(" ", "_"));
    }
}
