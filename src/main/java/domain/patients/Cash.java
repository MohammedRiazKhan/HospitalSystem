package domain.patients;

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
        public Account build() {
            return new Cash(this);
        }
    }


}
