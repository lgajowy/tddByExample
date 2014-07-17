import common.Currencies;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lukasz on 7/17/14.
 */
public class SumTest {

    private Bank bank;
    private final Expression fiveDollars = Money.dollar(5);
    private final Expression tenFrancs = Money.franc(10);


    @Before
    public void setUp() throws Exception {
        bank = new Bank();
        bank.addRate(Currencies.FRANC, Currencies.DOLLAR, 2);
    }

    @Test
    public void shouldAddMoneyToSum() throws Exception {
        Expression sum = new Sum(fiveDollars, tenFrancs).plus(fiveDollars);
        Money result = bank.reduce(sum, Currencies.DOLLAR);

        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void shouldMultiplySum() throws Exception {
        Expression sum = new Sum(fiveDollars, tenFrancs).times(2);
        Money result = bank.reduce(sum, Currencies.DOLLAR);

        assertEquals(Money.dollar(20), result);
    }
}
