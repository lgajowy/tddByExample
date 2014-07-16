import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by lukasz on 7/15/14.
 */
public class MoneyTest {

    @Test
    public void differentCurrenciesShouldNotBeEqual() throws Exception {
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void sameCurrencyWithTheSameAmountShouldBeEqual() throws Exception {
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
    }

    @Test
    public void shouldMultiplyWithoutChangingTheMoneyValue() throws Exception {
        Money five = Money.franc(5);
        Assert.assertEquals(Money.franc(10), five.times(2));
        Assert.assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void USDshouldBeDollarCurrency() throws Exception {
        assertEquals("USD", Money.dollar(1).currency());
    }

    @Test
    public void CHFshouldBeFrancCurrency() throws Exception {
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void shouldSumMoneyProperly() throws Exception {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
}
