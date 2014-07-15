/**
 * Created by lukasz on 7/15/14.
 */
public class Dollar {
    public int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }
}
