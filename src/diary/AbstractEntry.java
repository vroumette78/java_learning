package diary;

import java.security.KeyStore.Entry.Attribute;

public abstract class AbstractEntry implements Attributable, Timestampable {
    private long datePubli;
    private String auteur;

    public AbstractEntry(long datePubli, String auteur) {
        this.datePubli = datePubli;
        this.auteur = auteur;
    }

    public long getTimestamp() {
        return this.datePubli;
    }


    public String getAuthor() {
        return this.auteur;
    }


}
