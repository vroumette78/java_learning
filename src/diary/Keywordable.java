package diary;

import java.util.List;
import java.util.ArrayList;

public interface Keywordable {
    public void addKeyword(String keyword);
    public void removeKeyword(String keyword);
    public int keywordsCount();
    public List<String> getKeywords();
}
