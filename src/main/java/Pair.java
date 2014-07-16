/**
 * Created by lukasz on 7/16/14.
 */
public class Pair {

    String from;
    String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public boolean equals (Object object) {
        Pair pair = (Pair) object;
        return from.equals(pair.from) && to.equals(pair.to);
    }

    public int hashCode() {
        return 0;
    }
}
