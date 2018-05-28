package entity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by li on 2018/5/28.
 */
public class Account {

    private String type;
    private String accNo;
    private int PIN;
    private Customer customer;
    private double balance;
    private double unClearBalance;
    private double overDraftLimit;
    private boolean isSuspended;
    private boolean isActive;
    private boolean noticeNeeded;

    public Account(String type, Customer customer) {
        this.type = type;
        this.accNo = Bank.createAccountNumber();
        this.PIN = createPin();
        this.customer = customer;
        this.balance = 0;
        this.overDraftLimit = 0;
        this.unClearBalance = 0;
        this.isSuspended = false;
        this.isActive = true;
        this.noticeNeeded = false;
    }

    public enum Type {
        Saver, Junior, Current;
    }

    private int createPin() {
        Random random = new Random();
        String pin = "";
        for (int i = 0; i < 6; i++) {
            pin = String.valueOf(pin) + random.nextInt(10);
        }
        return Integer.valueOf(pin);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    public boolean isSuspended() {
        return isSuspended;
    }

    public void setSuspended(boolean suspended) {
        isSuspended = suspended;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isNoticeNeeded() {
        return noticeNeeded;
    }

    public void setNoticeNeeded(boolean noticeNeeded) {
        this.noticeNeeded = noticeNeeded;
    }

    public double getUnClearBalance() {
        return unClearBalance;
    }

    public void setUnClearBalance(double unClearBalance) {
        this.unClearBalance = unClearBalance;
    }
}
