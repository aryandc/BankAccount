package src;

import java.util.ArrayList;
import java.util.Collections;

public class BankAccount implements Comparable, Measurable {
    private float balance;
    private float rate;
    private static int accountNumber = 1000;

    public BankAccount(float rate) {
        this.balance = 0;
        this.rate = 0;
        accountNumber++;
    }

    public BankAccount(float balance, float rate){
        this.balance = balance;
        this.rate = rate;
        accountNumber++;
    }

    // processYear
    public void processYear() {
        float interest = balance * rate;
        balance += interest;
    }

    // processTwoYears
    public void processTwoYears() {
        int i = 0;
        while (i < 2) {
            processYear();
            i++;
        }
    }

    //getBalance
    public double getBalance() {
        return balance;
    }

    // processNYears
    public void processNYears(int years) {
        int i = 0;
        while (i < years) {
            // float interest = balance * rate;
            // balance += interest;
            // You can just call the processYear
            processYear();
            i++;
        }
    }

    private static void sort (ArrayList<BankAccount> list) {
        Collections.sort(list);
    }

    public static void main(String [] args) {

        BankAccount account = new BankAccount(1000, .1f);   // Here the client(main) is specifying the parameters.
        BankAccount anotherAccount = new BankAccount(.1f);  // Here the class and client(main) both are specifying the parameters.
        account.processYear();
        System.out.println("balance after first year is: " + account.balance);
        account.processNYears(3);
        System.out.println("balance after three years is: " + account.balance);

        BankAccount otherAccount = new BankAccount(1000, .1f);
        otherAccount.processNYears(10);
        System.out.println("otherAccount balance after 10 years: " + otherAccount.balance);

        System.out.println("Compare: " + account.compareTo(otherAccount));

        ArrayList<BankAccount> list = new ArrayList<>();
        list.add(account);
        list.add(anotherAccount);
        list.add(otherAccount);
        sort(list);
        System.out.println(list);

        ArrayList<Measurable> listOfMeasurables = new ArrayList<>();
        for (int i=0; i<list.size();)
    }

    @Override
    public String toString() {
        return "BankAccount[balance=" + balance + "]";
    }

    @Override
    public int compareTo(Object o) {
        BankAccount other = (BankAccount) o;

        if (this.balance > other.balance) {
            return 1;
        } else if (this.balance < other.balance) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * abstract class getMeasure.
     * @return measure.
     */
    @Override
    public float getMeasure() {
       return this.balance;
    }
}
