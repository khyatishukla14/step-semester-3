class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: negative salary given, starting at 0");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be greater than 0");
            return;
        }
        bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: percent must be between 0 and 100");
            return;
        }
        basicSalary -= basicSalary * percent / 100;
        System.out.printf("Tax deducted: %.0f%%%n", percent);
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class q2 {
    public static void main(String[] args) {
        PayrollAccount acc = new PayrollAccount(50000);
        acc.creditBonus(5000);
        acc.deductTax(10);
        System.out.println("Net salary: Rs " + acc.getNetSalary());
    }
}