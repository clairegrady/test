package search;

import data.KeywordType;

import java.util.List;

public interface Searchable {

    List<String> getAllKeywordsList();

    List<String> getKeywordsListForType(KeywordType type);

}