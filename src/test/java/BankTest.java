import common.Currencies;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by lukasz on 7/16/14.
 */
public class BankTest {

    private Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
    }

    @Test
    public void shouldReduceMoney() throws Exception {
        Money result = bank.reduce(Money.dollar(1), Currencies.DOLLAR);

        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void shouldReduceSum() throws Exception {
        Expression sum = new Sum (Money.dollar(3), Money.dollar(4));

        Money result = bank.reduce(sum, Currencies.DOLLAR);

        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void shouldReduceMoneyDifferentCurrency() throws Exception {
        bank.addRate(Currencies.FRANC, Currencies.DOLLAR, 2);

        Money result = bank.reduce(Money.franc(2), Currencies.DOLLAR);

        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void shouldIndenticalRateBeOne() throws Exception {
        assertEquals(1, new Bank().rate(Currencies.DOLLAR, Currencies.DOLLAR));
    }
}
