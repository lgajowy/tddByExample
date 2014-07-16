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

    @Test
    public void shouldPlusReturnSum() throws Exception {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void shouldReduceSum() throws Exception {
        Expression sum = new Sum (Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void shouldReduceMoney() throws Exception {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
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

