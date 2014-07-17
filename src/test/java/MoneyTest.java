import common.Currencies;
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
    private Bank bank;
    private final Expression fiveDollars = Money.dollar(5);
    private final Expression tenDollars = Money.dollar(10);
    private final Expression tenFrancs = Money.franc(10);

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
        assertEquals(tenDollars, fiveDollars.times(2));
        assertEquals(Money.dollar(15), fiveDollars.times(3));
    }

    @Test
    public void USDshouldBeDollarCurrency() throws Exception {
        assertEquals(Currencies.DOLLAR, Money.dollar(SOME_AMOUNT).currency());
    }

    @Test
    public void CHFshouldBeFrancCurrency() throws Exception {
        assertEquals(Currencies.FRANC, Money.franc(SOME_AMOUNT).currency());
    }

    @Test
    public void shouldSumMoneyProperly() throws Exception {
        Expression sum = fiveDollars.plus(fiveDollars);

        Money reduced = bank.reduce(sum, Currencies.DOLLAR);

        assertEquals(tenDollars, reduced);
    }

    @Test
    public void shouldPlusReturnSum() throws Exception {
        Expression result = fiveDollars.plus(fiveDollars);

        Sum sum = (Sum) result;

        assertEquals(fiveDollars, sum.augend);
        assertEquals(fiveDollars, sum.addend);
    }

    @Test
    public void shouldAddMixedCurrencies() throws Exception {
        bank.addRate(Currencies.FRANC, Currencies.DOLLAR, 2);

        Money result = bank.reduce(fiveDollars.plus(tenFrancs), Currencies.DOLLAR);

        assertEquals(tenDollars, result);
    }
}

