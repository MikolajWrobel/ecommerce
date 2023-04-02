package pl.mwrobel.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;


public class CreditCardTest {

    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-4567");
        CreditCard card2 = new CreditCard("1234-4567");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
        assertEquals(BigDecimal.valueOf(1000), card2.getBalance());
    }

    @Test
    void itAllowsToAssignDifferentCreditLimit() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-4567");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));

        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
    }

    @Test
    void itCantAssignLimitBelowCertainThreshold(){
        CreditCard card1 = new CreditCard("1234-4567");

        try {
            card1.assignCredit(BigDecimal.valueOf(10));
            fail("Should throw exception");
        } catch (CreditLimitBelowThresholdException e){
            assertTrue(true);
        }

        assertThrows(CreditLimitBelowThresholdException.class,
                () -> card1.assignCredit(BigDecimal.valueOf(10))); //lambda : card.assign

        assertThrows(CreditLimitBelowThresholdException.class,
                () -> card1.assignCredit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(
                () -> card1.assignCredit(BigDecimal.valueOf(100)));
    }
@Test
    void ItCantAssignLimitTwice() {
        try {
            CreditCard card1 = new CreditCard("1234-4567");
            card1.assignCredit(BigDecimal.valueOf(1000));
        } catch (ItCantAssignLimitTwiceException e){
            assertTrue(true);

        }
    }

    @Test
    void CantWithdrawLowerThanLimit(){
        try {
            CreditCard card1 = new CreditCard("1234-4567");
            card1.assignCredit(BigDecimal.valueOf(1000));
            card1.Withdraw(BigDecimal.valueOf(1001));
        } catch (CantWithdrawLowerThanLimit e){
            assertTrue(true);

        }
    }

    @Test
    void Withdraw(){
        CreditCard card1 = new CreditCard("1234-4567");
        card1.assignCredit(BigDecimal.valueOf(1000));
        card1.Withdraw(BigDecimal.valueOf(100));

    }


}
