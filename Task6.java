public class Task6 {
    public static void main(String[] args)
    {
        BankAccount[] arr = new BankAccount[3];
        arr[0] = new BankAccount("Assylzhan", 15000);
        arr[1] =new BankAccount("Kross", 17777);
        arr[2] = new BankAccount("Modric", 89778);

        for(BankAccount a:arr){
            System.out.println(a);
        }
    }
}

