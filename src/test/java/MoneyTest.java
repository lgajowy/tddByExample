import org.junit.Test;

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
}