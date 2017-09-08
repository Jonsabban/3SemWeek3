
package entity;

/**
 *
 * @author Sanox
 */
public class EntityQuote {
    
    private int id;
    private String quote;

    public EntityQuote(int id, String quote) {
        this.id = id;
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "QuoteEntity{" + "id=" + id + ", quote=" + quote + '}';
    }
    
}
