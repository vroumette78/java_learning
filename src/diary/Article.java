package diary;

public class Article extends AbstractEntry {
    private String content;

    public Article(long datePubli, String auth, String content) {
        super(datePubli, auth);
        this.content = content;
    }
    
    public String getContent(){
        return this.content;
    }

}
