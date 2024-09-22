
class Savings extends Account {
    private static int depositCounter = 1;
    private int depositCount;

    void withdraw (float withdraw) {
        super.withdraw(withdraw);
        if (super.balance() < 500) {
            System.out.println("Charging a fee of $10 because you are below $500");
            super.withdraw(10f);
        }
    }

    void deposit (float deposit) {
        super.deposit(deposit);
        this.depositCount = depositCounter++;
        System.out.println("This is deposit " + this.depositCount + " to this account");
        if (this.depositCount > 5) {
            System.out.println("Charging a fee of $10");
            super.withdraw(10f);
        }
    }

    void interest () {
        float interest = super.balance() * 1f * .015f;
        System.out.println("Customer earned " + interest + " in interest");
        super.deposit(interest);
    }
}

