package pl.mwrobel.creditcard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;


import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard("1234-4567");

        //Act
        card.assignCredit(BigDecimal.valueOf(1000));

        //Assert
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
    }

    @Test
    void itAllowsToAssignDifferentCreditLimit() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-4567");
        CreditCard card2 = new CreditCard("1234-4568");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1100));

        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
        assertEquals(BigDecimal.valueOf(1000), card2.getBalance());
    }

    @Test
    void itCantAssignLimitBelowCertainThreshold(){
        CreditCard card1 = new CreditCard("1234-4567");

        try {
            card1.assignCredit(BigDecimal.valueOf(1000));
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
}
