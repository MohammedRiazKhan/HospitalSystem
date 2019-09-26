package me.mohammedriazkhan.domain.patient;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Cash extends Account{

    private double cashAmount;
    private String paymentDate;

    public Cash(){}

    private Cash(CashBuilder builder){

        super(builder);
        this.cashAmount = builder.cashAmount;
        this.paymentDate = builder.paymentDate;

    }

    public double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public static class CashBuilder extends Account.AccountBuilder{

        private double cashAmount;
        private String paymentDate;

        public CashBuilder(){
            super();
        }

        public CashBuilder cashAmount(double cashAmount){
            this.cashAmount = cashAmount;
            return this;
        }

        public CashBuilder paymentDate(String paymentDate){
            this.paymentDate = paymentDate;
            return this;
        }

        public CashBuilder copy(Cash cash){

            this.cashAmount(cash.getCashAmount());
            this.paymentDate(cash.getPaymentDate());
            return this;
        }


        @Override
        public Account build() {
            return new Cash(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            CashBuilder that = (CashBuilder) o;
            return Double.compare(that.cashAmount, cashAmount) == 0 &&
                    Objects.equals(paymentDate, that.paymentDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), cashAmount, paymentDate);
        }

        @Override
        public String toString() {
            return "CashBuilder{" +
                    "cashAmount=" + cashAmount +
                    ", paymentDate='" + paymentDate + '\'' +
                    "} " + super.toString();
        }
    }


}
