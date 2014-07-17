import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by lukasz on 7/15/14.
 */
public class MoneyTest {
    private final int SOME_AMOUNT = 1;
    Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
    }

    @Test
    public void differentCurrenciesShouldNotBeEqual() throws Exception {
        assertFalse(Money.franc(SOME_AMOUNT).equals(Money.dollar(SOME_AMOUNT)));
    }

    @Test
    public void sameCurrencyWithTheSameAmountShouldBeEqual() throws Exception {
        assertTrue(Money.franc(SOME_AMOUNT).equals(Money.franc(SOME_AMOUNT)));
        assertTrue(Money.dollar(SOME_AMOUNT).equals(Money.dollar(SOME_AMOUNT)));
    }

    @Test
    public void shouldMultiplyWithoutChangingTheMoneyValue() throws Exception {
        Money five = Money.franc(5);
        Assert.assertEquals(Money.franc(10), five.times(2));
        Assert.assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void USDshouldBeDollarCurrency() throws Exception {
        assertEquals("USD", Money.dollar(SOME_AMOUNT).currency());
    }

    @Test
    public void CHFshouldBeFrancCurrency() throws Exception {
        assertEquals("CHF", Money.franc(SOME_AMOUNT).currency());
    }

    @Test
    public void shouldSumMoneyProperly() throws Exception {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void shouldPlusReturnSum() throws Exception {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void shouldAddMixedCurrencies() throws Exception {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveDollars.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }
}

