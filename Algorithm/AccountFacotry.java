public class AccountFacotry {
    private int accountNumber;
    private static AccountFacotry facotry;

    private AccountFacotry() {}
    
    public AccountFacotry getFacotry() {
        if(facotry == null) {
            facotry = new AccountFacotry();
        }
        return facotry;
    }

    public int getAccount() {
        return accountNumber++;
    }
}
   