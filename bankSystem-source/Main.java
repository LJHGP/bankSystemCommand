import entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static Scanner scanner;

    private static Account currentAccount = null;

    public static void main(String[] args) throws ParseException {
        suspendAccount();
  /*      scanner = new Scanner(System.in);
        String choice;
        System.out.println("Welcome to the system of Bank");
        indexPage:
        while (true) {
            if (currentAccount != null) {
                break indexPage;
            }
            indexPage();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    sigIn();
                    break;
                case "2":
                    loginIn();
                    break;
                case "0":
                    System.out.println("Bye!");
                    return;
                default:
                    break;
            }
        }


        System.out.println("you are login...");
        while (true) {
            businessPage();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    withdraw();
                    break;
                case "2":
                    depositCash();
                    break;
                case "3":
                    depositCheque();
                    break;
                case "4":
                    clearFunds();
                    break;
                case "5":
                    suspendAccount();
                    break;
                case "6":
                    reinstateAccount();
                    break;
                case "7":
                    showDetail(currentAccount);
                    break;
                case "8":
                    closeAccount();
                    break;
                case "0":
                    System.out.println("Bye!");
                    return;
                default:
                    break;

            }
        }*/
    }



    private static void closeAccount() {
    }

    private static void reinstateAccount() {
    }

    private static void clearFunds() {
    }

    private static void suspendAccount() {
        scanner = new Scanner(System.in);
        System.out.println("!!!! The following actions will freeze your account and you will not be able to perform other business operations ");
        System.out.println("!!!! can you continue?(YES or NO)");
        String chose = scanner.nextLine();
        if("yes".equals(chose)){//
            currentAccount.setActive(false);
            currentAccount.setSuspended(true);
            System.out.println("! Your account has been frozen!");
            System.out.println("! You can reactivate your account in the following ways!");
            System.out.println("!!!! can you continue?(YES or NO)");
            chose = scanner.nextLine();
            if("yes".equals(chose)){
                reinstateAccount();
                System.out.println("! Your account has been reactivated!");
            }
        }
    }

    private static void depositCheque() {
    }

    private static void depositCash() {
    }

    private static void withdraw() {
        System.out.println("* Please input amount:");
        String amount = scanner.nextLine();
        //if(Account)

    }

    private static void indexPage() {
        System.out.println("Please choose option:");
        System.out.println("[1] SignIn");
        System.out.println("[2] Login");
        System.out.println("[0] Exit");
    }

    private static void businessPage() {
        System.out.println("Please choose option:");
        System.out.println("[1] Withdraw");
        System.out.println("[2] Deposit Cash");
        System.out.println("[3] Deposit Cheque");
        System.out.println("[4] Clear Funds");
        System.out.println("[5] Suspend Account");
        System.out.println("[6] Reinstate Account");
        System.out.println("[7] Show Account");
        System.out.println("[8] Close Account");
        System.out.println("[0] Exit");
    }

    private static void sigIn() throws ParseException {
        System.out.println("* Please input your name:");
        String name = scanner.nextLine();
        System.out.println("* Please input your address:");
        String address = scanner.nextLine();
        System.out.println("* Please input your birth:(e.g. 20180501)");
        String birth = scanner.nextLine();
        System.out.println("* Please choose your account type: (Saver,Junior,Current)");
        String type = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if (name.trim().isEmpty() || birth.trim().isEmpty()) {
            System.out.println("Your name or birth is empty.Please try again");
            return;
        }
        if (!birth.matches("d[8]")) {
            System.out.println("Your birth is wrong");
            return;
        }
        Date birthDate = sdf.parse(birth);
        boolean isExist = Bank.checkCustomerName(name);
        if (isExist) {
            System.out.println("your name is exist. Please tyr again.");
            return;
        }
        Customer customer = new Customer(name, address, birthDate);
        if (!customer.isCreditStatus()) {
            System.out.println("Because of your creditStatus,you are not allowed to create account!Please try again");
            return;
        }
        boolean flag = false;
        for (Account.Type accType : Account.Type.values()) {
            if (accType.name().equals(type)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("* Please input correct type. Please try again");
            return;
        }
        String accountNumber = Bank.createAccountNumber();
        Calendar birthCal = Calendar.getInstance();
        birthCal.setTime(birthDate);
        Date today = sdf.parse(sdf.format(new Date()));
        Calendar todayCal = Calendar.getInstance();
        todayCal.setTime(today);
        if (todayCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR) < 16 && !Objects.equals(type, Account.Type.Junior.name())) {
            System.out.println("Only 19 age can choose junior account. Please try again");
            return;
        }
        Account account;
        if (type.equals(Account.Type.Saver.name())) {
            account = new SaverAccount(Account.Type.Saver.name(), customer);
        } else if (type.equals(Account.Type.Junior.name())) {
            account = new JuniorAccount(Account.Type.Junior.name(), customer);
        } else {
            account = new CurrentAccount(Account.Type.Current.name(), customer);
        }
        account.setAccNo(accountNumber);
        Bank.createAccount(account);
        showDetail(account);
        return;
    }

    private static void showDetail(Account account) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println("--------DETAIL--------");
        System.out.println("name:\t\t" + account.getCustomer().getName());
        System.out.println("address:\t\t" + account.getCustomer().getAddress());
        System.out.println("birth:\t\t" + sdf.format(account.getCustomer().getDayOfBirth()));
        System.out.println("accNo:\t\t" + account.getAccNo());
        System.out.println("PIN:\t\t" + account.getPIN());
        System.out.println("balance:\t\t" + account.getBalance());
        System.out.println("unClearBalance:\t\t" + account.getUnClearBalance());
        System.out.println("overDraftLimit:\t\t" + account.getOverDraftLimit());
        System.out.println("isSuspended:\t\t" + account.isSuspended());
        System.out.println("isActive:\t\t" + account.isActive());
        System.out.println("noticeNeeded:\t\t" + account.isNoticeNeeded());
        System.out.println("--------DETAIL--------");
    }


    private static void loginIn() {
        System.out.println("* Please input your account number:");
        String accountNumber = scanner.nextLine();
        System.out.println("* Please input your PIN:");
        String pin = scanner.nextLine();
        Account account = Bank.findAccount(accountNumber);
        if (Objects.isNull(account)) {
            System.out.println("Your account is not exist. Please try again.");
            return;
        }
        if (!Objects.equals(String.valueOf(account.getPIN()), pin)) {
            System.out.println("Your pin is wrong. Please try again.");
            return;
        }
        currentAccount = account;
    }



}
