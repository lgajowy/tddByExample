import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by lukasz on 7/16/14.
 */
public class BankTest {

    @Test
    public void shouldReduceMoney() throws Exception {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void shouldReduceSum() throws Exception {
        Expression sum = new Sum (Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void shouldReduceMoneyDifferentCurrency() throws Exception {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void shouldRateIndenticalBe1() throws Exception {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }
}
