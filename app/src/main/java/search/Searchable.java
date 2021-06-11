package search;

import data.KeywordType;

import java.util.List;

public interface Searchable {

    public List<String> getAllKeywordsList();
    public List<String> getKeywordsListForType(KeywordType type);

}