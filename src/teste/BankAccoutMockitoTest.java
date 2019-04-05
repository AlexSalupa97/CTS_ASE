package teste;

import clase.BankAccount;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BankAccoutMockitoTest {

    @Test
    public void testMockitoRight(){
        BankAccount bankAccount=mock(BankAccount.class);
//        doReturn((double)100).when(bankAccount).getBalance();

        when(bankAccount.getBalance()).thenReturn((double)100);

        assertEquals(100,bankAccount.getBalance(),0.01);
    }
}
