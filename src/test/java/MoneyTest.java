import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by lukasz on 7/15/14.
 */
public class MoneyTest {

    @Test
    public void differentCurrenciesShouldNotBeEqual() throws Exception {
        assertFalse(new Franc(5).equals(new Dollar(5)));
    }

    @Test
    public void sameCurrencyWithTheSameAmountShouldBeEqual() throws Exception {
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertTrue(new Dollar(5).equals(new Dollar(5)));
    }
}
