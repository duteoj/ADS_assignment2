import java.util.*;

public static void addAccount(String username, double balance, MyLinkedList<BankAccount> accounts){
    accounts.add(new BankAccount(username, balance));
    System.out.println("Account added successfully");

}

public static void displayAccounts(MyLinkedList<BankAccount> accounts){
    if(accounts.isEmpty()){
        System.out.println("Account list is empty");
        return;
    }
    System.out.println("Account list:");
    for (Object obj : accounts.toArray()) {
        System.out.println((BankAccount) obj);
    }
    System.out.println();
}

public static BankAccount findAccount(String username, MyLinkedList<BankAccount> accounts) {
    for (Object obj : accounts.toArray()) {
        BankAccount acc = (BankAccount) obj;
        if (acc.getUsername().equals(username)) {
            return acc;
        }
    }
    return null;
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MyLinkedList<BankAccount> accounts = new MyLinkedList<>();
    MyStack<String> transactions = new MyStack<>();
    MyQueue<String> bill = new MyQueue<>();
    MyQueue<BankAccount> requests = new MyQueue<>();

    while(true){
        System.out.println("1 - Enter Bank");
        System.out.println("2 - Enter ATM");
        System.out.println("3 - Admin Area");
        System.out.println("4 - Exit");

        int choice = sc.nextInt();

        switch(choice){
            case 1:
                boolean flagbank = true;
                while(flagbank){
                    System.out.println("1 - Create Account");
                    System.out.println("2 - Find Account");
                    System.out.println("3 - Go back");

                    int choice10 = sc.nextInt();

                    switch(choice10){
                        case 1:
                            System.out.println("Enter username: ");
                            String username = sc.next();

                            System.out.println("Enter balance: ");
                            double balance = sc.nextDouble();

                            requests.offer(new BankAccount(username, balance));
                            System.out.println("Request submitted successfully");
                            break;

                        case 2:
                            System.out.println("Enter username: ");
                            String username10 = sc.next();
                            BankAccount username1 = findAccount(username10, accounts);
                            boolean flagfind = true;
                            while(flagfind){
                                System.out.println("1 - Withdraw");
                                System.out.println("2 - Deposit");
                                System.out.println("3 - Exit");

                                int choice11 = sc.nextInt();

                                switch(choice11){
                                    case 1:
                                        System.out.println("Enter withdraw amount: ");
                                        double balance1 = sc.nextDouble();
                                        username1.withdraw(balance1);
                                        transactions.push("Withdraw " + balance1 + " from " + username1.getUsername());
                                        System.out.println("Remainder: "+username1.getBalance());
                                        break;
                                    case 2:
                                        System.out.println("Enter deposit amount: ");
                                        double balance2 = sc.nextDouble();
                                        username1.deposit(balance2);
                                        transactions.push("Deposit " + balance2 + " to " + username1.getUsername());
                                        System.out.println("Remainder: "+username1.getBalance());
                                        break;
                                    case 3:
                                        flagfind = false;
                                        break;
                                }
                            }
                            break;
                        case 3:
                            flagbank = false;
                            break;

                    }


                }
                break;
            case 2:
                System.out.println("Enter username: ");
                String username20 = sc.next();
                boolean flagatm = true;
                while(flagatm){
                    BankAccount username21 = findAccount(username20, accounts);

                    System.out.println("1 - Balance enquiry");
                    System.out.println("2 - Withdraw");
                    System.out.println("3 - Go Back");

                    int choice20 = sc.nextInt();
                    switch(choice20){
                        case 1:
                            System.out.println(username21.getBalance());
                            break;
                        case 2:
                            System.out.println("Enter withdraw amount: ");
                            double balance21 = sc.nextDouble();
                            username21.withdraw(balance21);
                            transactions.push("Withdraw " + balance21 + " from " + username21.getUsername());
                            System.out.println("Remainder: "+username21.getBalance());
                            break;
                        case 3:
                            flagatm = false;
                            break;
                    }
                }
                break;
            case 3:
                boolean flagadmin = true;
                while(flagadmin){
                    System.out.println("1 - Display accounts");
                    System.out.println("2 - Users requests");
                    System.out.println("3 - Bill payments");
                    System.out.println("4 - Operations with transactions");
                    System.out.println("5 - Go Back");



                    int choice30 =  sc.nextInt();

                    switch(choice30){
                        case 1:
                            displayAccounts(accounts);
                            break;
                        case 2:
                            boolean flag3 = true;
                            while(flag3){
                                System.out.println("1 - View requests");
                                System.out.println("2 - Process request");
                                System.out.println("3 - Exit");

                                int choice44  = sc.nextInt();

                                switch(choice44){
                                    case 1:
                                        if(requests.isEmpty()){
                                            System.out.println("Request list is empty");
                                        }
                                        else{
                                            System.out.println("Display pending requests: ");
                                            for(Object obj : requests.toArray()){
                                            System.out.println(((BankAccount) obj).getUsername());
                                            }
                                        }
                                        break;
                                    case 2:
                                        if(requests.isEmpty()){
                                            System.out.println("Request list is empty");
                                        }
                                        else{
                                            BankAccount temp = requests.poll();
                                            addAccount(temp.getUsername(), temp.getBalance(),  accounts);
                                            System.out.println("Request submitted successfully");
                                        }
                                        break;
                                    case 3:
                                        flag3 = false;
                                        break;
                                }
                            }
                            break;
                        case 3:
                            boolean flag2 = true;
                            while(flag2) {
                                System.out.println("1 - Add bill");
                                System.out.println("2 - Process bill");
                                System.out.println("3 - Show remaining bill(s)");
                                System.out.println("4 - Exit");

                                int choice31 = sc.nextInt();

                                switch(choice31){
                                    case 1:
                                        System.out.println("Enter bill name: ");
                                        String billn = sc.next();
                                        bill.offer(billn);
                                        System.out.println("Added: " + billn);
                                        break;
                                    case 2:
                                        if(bill.isEmpty()){
                                            System.out.println("Bill is empty");
                                        }
                                        else{
                                            System.out.println("Processing: " + bill.poll());
                                        }
                                        break;
                                    case 3:
                                        if(bill.isEmpty()){
                                            System.out.println("Bill is empty");
                                        }
                                        else{
                                            System.out.println("Remaining: ");
                                            for(Object obj : bill.toArray()){
                                                System.out.println((String) obj);
                                            }
                                        }
                                        break;
                                    case 4:
                                        flag2 = false;
                                        break;
                                }
                            }
                            break;
                        case 4:
                            boolean flag1 = true;
                            while(flag1) {
                                System.out.println("1 - Last transaction");
                                System.out.println("2 - Undo last transaction");
                                System.out.println("3 - Exit");

                                int choice27 = sc.nextInt();

                                switch(choice27){
                                    case 1:
                                        System.out.println("Last transaction: "+transactions.peek());
                                        break;
                                    case 2:
                                        String t1 = transactions.peek();
                                        System.out.println("Undo -> " + t1.substring(0, 8) + " removed");
                                        transactions.pop();
                                        System.out.println();
                                        break;
                                    case 3:
                                    flag1 = false;
                                    break;
                                }
                            }
                            break;
                        case 5:
                            flagadmin = false;
                            break;
                    }
                }

                break;
            case 4:
                System.exit(0);
        }


    }
}