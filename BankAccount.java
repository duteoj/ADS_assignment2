public class BankAccount {
    private static int id_gen = 1;
    public int id;
    private String username;
    private double balance;

    public BankAccount(String username, double balance) {
        this.id = id_gen++;
        this.setUsername(username);
        this.setBalance(balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void withdraw(double balance) {
        if(this.balance < balance || balance <= 0) {
            System.out.println("Insufficient balance");
        }
        else{this.balance -= balance;}
    }

    public void deposit(double balance) {
        if(balance <= 0) {
            System.out.println("Insufficient balance");
        }
        else{this.balance += balance;}
    }

    @Override
    public String toString() {
        return username + " – Balance: " + balance;
    }
}
