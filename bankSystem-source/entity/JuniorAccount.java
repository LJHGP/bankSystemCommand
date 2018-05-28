package entity;

/**
 * Created by li on 2018/5/29.
 */
public class JuniorAccount extends Account {


    public JuniorAccount(String type, Customer customer) {
        super(Type.Junior.name(), customer);
        this.setOverDraftLimit(0);
    }
}
