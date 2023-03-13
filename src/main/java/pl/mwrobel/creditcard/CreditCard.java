package pl.mwrobel.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    public CreditCard(String cardNumber){
    }
    public void assignCredit(BigDecimal creditAmount){
        if (isBelowThreshold(creditAmount)) {
            throw new CreditLimitBelowThresholdException();
        }
        this.balance = creditAmount;
    }

    private static boolean isBelowThreshold(BigDecimal creditAmount) {
        return creditAmount.compareTo(BigDecimal.valueOf(100)) <= 1;
    }

    public BigDecimal getBalance(){
        return balance;
    }
}
