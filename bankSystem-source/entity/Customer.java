package entity;

import java.util.Date;
import java.util.Random;

/**
 * Created by li on 2018/5/28.
 */
public class Customer {

    private String name;

    private String address;

    private Date dayOfBirth;

    private boolean creditStatus;

    public Customer(String name, String address, Date dayOfBirth) {
        this.name = name;
        this.address = address;
        this.dayOfBirth = dayOfBirth;
        Random random = new Random();
        this.creditStatus = random.nextBoolean();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public boolean isCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(boolean creditStatus) {
        this.creditStatus = creditStatus;
    }
}
