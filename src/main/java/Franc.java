/**
 * Created by lukasz on 7/15/14.
 */
class Franc extends Money {

    Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }
}
