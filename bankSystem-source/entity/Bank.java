package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by li on 2018/5/29.
 */
public class Bank {

    private static Map<String, Account> allAccount = new HashMap<>();

    private static Map<String, Customer> allCustomer = new HashMap<>();


    public static Account createAccount(Account account) {
        allAccount.put(account.getAccNo(), account);
        allCustomer.put(account.getCustomer().getName(), account.getCustomer());
        return account;
    }


    public static String createAccountNumber() {
        Random random = new Random();
        StringBuilder stringBuilder;
        while (true) {
            stringBuilder = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                stringBuilder.append(random.nextInt(10));
            }
            if (!allAccount.containsKey(stringBuilder.toString())) {
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static boolean checkCustomerName(String name) {
        return allCustomer.containsKey(name);
    }

    public static Account findAccount(String number) {
        return allAccount.get(number);
    }


}
