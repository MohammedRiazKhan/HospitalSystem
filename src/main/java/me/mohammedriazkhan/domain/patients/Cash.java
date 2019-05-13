package me.mohammedriazkhan.domain.patients;

public class Cash extends Account{

    private double cashAmount;

    public Cash(){

    }

    private Cash(CashBuilder builder){

        super(builder);
        this.cashAmount = builder.cashAmount;

    }

    public double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public static class CashBuilder extends Account.AccountBuilder{

        private double cashAmount;

        private CashBuilder cashAmount(double cashAmount){
            this.cashAmount = cashAmount;
            return this;
        }


        @Override
        public String toString() {
            return "CashBuilder{" +
                    "cashAmount=" + cashAmount +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CashBuilder that = (CashBuilder) o;

            return Double.compare(that.cashAmount, cashAmount) == 0;

        }

        @Override
        public int hashCode() {
            long temp = Double.doubleToLongBits(cashAmount);
            return (int) (temp ^ (temp >>> 32));
        }

        @Override
        public Account build() {
            return new Cash(this);
        }
    }


}
