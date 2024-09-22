public class Account {
    private int id;
    private float balance;
    private static int counter = 10000;

    Account () {
        this.id = ++counter;
        this.balance = 0;
    }
    Account (float balance) {
        this.id = ++counter;
        this.balance = balance;
    }

    int id() {
        return this.id;
    }

    void balance(float balance) {
        this.balance = balance;
    }
    float balance() {
        return this.balance;
    }

    void withdraw (float withdraw) {
        this.balance -= withdraw;
    }

    void deposit (float deposit) {
        this.balance += deposit;
    }
}
