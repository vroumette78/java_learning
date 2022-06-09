package diary;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractMedia extends AbstractEntry implements Keywordable{
    List<String> keywordsList;

    public AbstractMedia(long date, String aut) {
        super(date, aut);
        keywordsList = new ArrayList<String>();
    }
    
    public void addKeyword(String keyword){
        if(keywordsList != null){
            if(keyword!=null){
                if (!this.keywordsList.contains(keyword)){
                    this.keywordsList.add(keyword);
                }
            }
        }
    }

    public void removeKeyword(String keyword){
        if(keywordsList != null){
            if (this.keywordsList.contains(keyword)){
                this.keywordsList.remove(keyword);
            }
        }
    }
    public int keywordsCount(){
        if(keywordsList == null){
            return 0;
        }
        return this.keywordsList.size();
    }
    public List<String> getKeywords(){
        List<String> empty = new ArrayList<String>();
        if(keywordsList == null){
            return empty;
        }
        return keywordsList;
        
    }
}
