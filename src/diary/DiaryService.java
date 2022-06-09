package diary;

import java.util.*;

public interface DiaryService {
    public String getTitle();
    public void post(Attributable entry);
    public List<Attributable> getEntries();
    public int getEntriesCount();
    public int getKeywordableEntriesCount();
    public List<Attributable> findEntriesByAuthor(String author);
    public Timestampable getLatestEntry();
    public List<Keywordable> findEntriesByKeywords(String[] keywords);
    public List<Article> findEntriesByContent(String[] str);
    public List<AbstractEntry> findEntriesByKeywordsOrContent(String[] keywords);
}
