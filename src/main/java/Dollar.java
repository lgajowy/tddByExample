/**
 * Created by lukasz on 7/15/14.
 */
public class Dollar extends Money{

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Money times(int multiplier) {
        return new Dollar(amount * multiplier);
    }


}
