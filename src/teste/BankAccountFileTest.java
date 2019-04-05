package teste;

import clase.BankAccount;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static org.junit.Assert.*;

public class BankAccountFileTest {

    private ArrayList<BankAccount> listaBankAccounts;
    private ArrayList<Double> listaExpectedValues;
    private ArrayList<Double> listaWithdrawValues;

    @Before
    public void setup()  {
        System.out.println("cevaBefore");
        listaBankAccounts = new ArrayList<>();
        listaWithdrawValues=new ArrayList<>();
        listaExpectedValues=new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("BankAccount.txt"))) {
            String line;


            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);

                listaBankAccounts.add(new BankAccount(Double.valueOf(tokenizer.nextToken()), Double.valueOf(tokenizer.nextToken()), Double.valueOf(tokenizer.nextToken())));
                listaWithdrawValues.add(Double.valueOf(tokenizer.nextToken()));
                listaExpectedValues.add(Double.valueOf(tokenizer.nextToken()));

            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @AfterClass
    public static void teardown() {
        System.out.println("cevaAfter");
    }

    @Test
    public void testWithdrawRight() {
        for(int i=0;i<listaExpectedValues.size();i++) {
            listaBankAccounts.get(i).withdraw(listaWithdrawValues.get(i));
            assertEquals(listaExpectedValues.get(i), listaBankAccounts.get(i).getBalance(), 0.1);
        }
    }
}
