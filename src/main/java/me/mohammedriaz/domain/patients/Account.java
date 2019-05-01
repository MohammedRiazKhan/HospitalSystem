package me.mohammedriaz.domain.patients;

public abstract class Account {

    private int accountNo;
    private double balance;
    private String paymentTerms;

    public Account(){

    }


    protected Account(AccountBuilder builder){

        this.accountNo = builder.accountNo;
        this.balance = builder.balance;
        this.paymentTerms = builder.paymentTerms;

    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public abstract static class AccountBuilder {
        private int accountNo;
        private double balance;
        private String paymentTerms;

        public AccountBuilder accountNo(int accountNo){
            this.accountNo = accountNo;
            return this;
        }

        public AccountBuilder balance(double balance){
            this.balance = balance;
            return this;

        }

        public AccountBuilder paymentTerms(String paymentTerms){

            this.paymentTerms = paymentTerms;
            return this;
        }

        public abstract Account build();

        @Override
        public String toString() {
            return "AccountBuilder{" +
                    "accountNo=" + accountNo +
                    ", balance=" + balance +
                    ", paymentTerms='" + paymentTerms + '\'' +
                    '}';
        }
    }


}
