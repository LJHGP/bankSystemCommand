package entity;

/**
 * Created by li on 2018/5/29.
 */
public class CurrentAccount extends Account {

    private final double limitAmount = 100;

    public CurrentAccount(String type, Customer customer) {
        super(Type.Current.name(), customer);
        this.setOverDraftLimit(0);
    }
}
