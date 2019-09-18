package me.mohammedriazkhan.domain.patient;

import java.util.Objects;

public abstract class Account {

    private String accountId;
    private double balance;
    private String paymentTerms;

    public Account(){}

    protected Account(AccountBuilder builder){

        this.accountId = builder.accountId;
        this.balance = builder.balance;
        this.paymentTerms = builder.paymentTerms;

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
        private String accountId;
        private double balance;
        private String paymentTerms;

        public AccountBuilder accountId(String accountId){
            this.accountId = accountId;
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
                    "accountId=" + accountId +
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
                    Objects.equals(accountId, that.accountId) &&
                    Objects.equals(paymentTerms, that.paymentTerms);
        }

        @Override
        public int hashCode() {
            return Objects.hash(accountId, balance, paymentTerms);
        }
    }


}
