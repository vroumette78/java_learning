package diary;

public class Video extends AbstractMedia {
    private String url;
    private String title;
    private int length;

    public Video(long datePubli, String auth, String url, String title, int length) {
        super(datePubli, auth);
        this.url = url;
        this.title = title;
        this.length = length;
    }

    public String getURL() {
        return this.url;
    }

    public String getTitle() {
        return this.title;
    }
    public int getLength() {
        return this.length;
    }

}