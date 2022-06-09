package diary;

import java.util.*;

public class DiaryServiceImpl implements DiaryService {
    
    private String title;
    private List<Attributable> contenus = new ArrayList<Attributable>();

    public DiaryServiceImpl(String titre) {
        this.title = titre;
    }
    
    public String getTitle(){
        return this.title;
    }

    public void post(Attributable entry){
        if (!contenus.contains(entry) && entry!=null){
            contenus.add(entry);
        }
    }

    public List<Attributable> getEntries(){
        return contenus;
    }

    public int getEntriesCount(){
        return contenus.size();
    }

    public int getKeywordableEntriesCount(){
        int nb = 0;
        for(Attributable entry : contenus){
            if (entry instanceof Keywordable)
                nb += 1;
        }
        return nb;
    }

    public List<Attributable> findEntriesByAuthor(String author){
        List<Attributable> entreesAuteur = new ArrayList<Attributable>();
        for(Attributable entry : contenus) {
            if (entry.getAuthor().equals(author))
                entreesAuteur.add(entry);
        }
        return entreesAuteur;
    }

    public Timestampable getLatestEntry(){
        List<Long> dates = new ArrayList<Long>();
        if (contenus.isEmpty())
            return null;
        else {
            for(Attributable entry : contenus) {
                if (entry instanceof Timestampable)
                    dates.add(((Timestampable)entry).getTimestamp());
            }
            int index = dates.indexOf(Collections.max(dates));
            return ((Timestampable)contenus.get(index));
        }
    }

    public List<Keywordable> findEntriesByKeywords(String[] keywords){
        List<Keywordable> entrees = new ArrayList<Keywordable>();
        for(Attributable entry : contenus) {
            if (entry instanceof AbstractMedia) {
                AbstractMedia entry2 = (AbstractMedia) entry;
                Boolean tousLa = true;
                for (String k : keywords) {
                    if (!entry2.getKeywords().contains(k)) {
                        tousLa=false;
                        break;
                    }
                }
                if (tousLa)
                    entrees.add(entry2);
            }
        }
        return entrees;
    }

    public List<Article> findEntriesByContent(String[] str){
        List<Article> entrees = new ArrayList<Article>();
        for(Attributable entry : contenus) {
            if (entry instanceof Article) {
                Article entry2 = (Article) entry;
                Boolean tousLa = true;
                for (String k : str) {
                    if (!entry2.getContent().contains(k)) {
                        tousLa=false;
                        break;
                    }
                }
                if (tousLa)
                    entrees.add(entry2);
            }
        }
        return entrees;
    }

    public List<AbstractEntry> findEntriesByKeywordsOrContent(String[] keywords){
        List<AbstractEntry> entrees = new ArrayList<AbstractEntry>();
        entrees.addAll(findEntriesByContent(keywords));
        for(Keywordable entry : findEntriesByKeywords(keywords))
            entrees.add(((AbstractMedia)entry));
        return entrees;
    }

}
