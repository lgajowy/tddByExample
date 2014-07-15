import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lukasz on 7/15/14.
 */
public class FrancTest {

    @Test
    public void shouldMultiplyWithoutChangingTheFranc() throws Exception {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }
}
