/**
 * Created by lukasz on 7/15/14.
 */
public abstract class Money {
    protected int amount;
    protected String currency;

    protected Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }

    abstract Money times(int multiplier);

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public String currency() {
        return currency;
    }
}
