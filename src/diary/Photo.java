package diary;

public class Photo extends AbstractMedia {
    private String url;
    private String caption;

    public Photo(long datePubli, String auth, String url, String caption) {
        super(datePubli, auth);
        this.url = url;
        this.caption = caption;
    }

    public String getURL() {
        return this.url;
    }

    public String getCaption() {
        return this.caption;
    }

}
