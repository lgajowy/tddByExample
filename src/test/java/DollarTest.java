import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lukasz on 7/15/14.
 */
public class DollarTest {

    @Test
    public void shouldMultiplyDollarByTwo() throws Exception {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }
}
