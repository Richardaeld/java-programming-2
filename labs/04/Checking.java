class Checking extends Account{
    void withdraw (float withdraw) {
        if (withdraw > super.balance()) {
            System.out.println("Charging an overdraft fee of $20 because account is below $0");
            super.withdraw(20f);
        }
        super.withdraw(withdraw);
    }
}
