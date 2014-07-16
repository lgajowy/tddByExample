/**
 * Created by lukasz on 7/16/14.
 */
public interface Expression {
    Money reduce(Bank bank, String to);
}
