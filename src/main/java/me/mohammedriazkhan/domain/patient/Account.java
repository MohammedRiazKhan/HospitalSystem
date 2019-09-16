package me.mohammedriazkhan.domain.patient;

import java.util.Objects;

public abstract class Account {

    private String accountNo;
    private double balance;
    private String paymentTerms;

    public Account(){}

    protected Account(AccountBuilder builder){

        this.accountNo = builder.accountNo;
        this.balance = builder.balance;
        this.paymentTerms = builder.paymentTerms;

    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
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
        private String accountNo;
        private double balance;
        private String paymentTerms;

        public AccountBuilder accountNo(String accountNo){
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AccountBuilder that = (AccountBuilder) o;
            return Double.compare(that.balance, balance) == 0 &&
                    Objects.equals(accountNo, that.accountNo) &&
                    Objects.equals(paymentTerms, that.paymentTerms);
        }

        @Override
        public int hashCode() {
            return Objects.hash(accountNo, balance, paymentTerms);
        }
    }


}
