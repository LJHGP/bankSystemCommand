package entity;

/**
 * Created by li on 2018/5/29.
 */
public class SaverAccount extends Account {

    public SaverAccount(String type, Customer customer) {
        super(Type.Saver.name(), customer);
        this.setOverDraftLimit(0);
    }
}
