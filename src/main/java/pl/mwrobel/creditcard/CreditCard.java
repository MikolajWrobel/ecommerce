package pl.mwrobel.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal credit;
    public CreditCard(String cardNumber){

    }
    public void assignCredit(BigDecimal creditAmount){
        if (isBelowThreshold(creditAmount)) {
            throw new CreditLimitBelowThresholdException();
        }

        if (isAlreadyAssigned()) {
            throw new ItCantAssignLimitTwiceException();
        }
            this.credit = creditAmount;
            this.balance = creditAmount;
    }

    public void Withdraw(BigDecimal withdrawAmount){
        if (withdrawAmount.compareTo(getCredit()) > 0){
            throw new CantWithdrawLowerThanLimit();
        } else {
            this.balance.subtract(withdrawAmount) ;
        }

    }

    private boolean isAlreadyAssigned() {
        return this.getCredit() != null;
    }

    private static boolean isBelowThreshold(BigDecimal creditAmount) {
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public BigDecimal getCredit() {
        return credit;
    }




}
