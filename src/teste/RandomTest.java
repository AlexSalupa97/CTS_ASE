package teste;

import clase.BankAccount;
import dubluri.BancaDummy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class RandomTest {


    @Test
    public void testAssertNull() {
        ArrayList<BankAccount> list = null;
        assertNull(list);
    }

    @Test
    public void testAssertNotNull() {
        ArrayList<BankAccount> list = new ArrayList<>();
        assertNotNull(list);
    }

    @Test
    public void testAssertSame(){
        int x=1;
        BancaDummy bancaDummy1=new BancaDummy();
        BancaDummy bancaDummy2=new BancaDummy();
        ArrayList<BancaDummy> list=new ArrayList<>();
        list.add(bancaDummy1);
        list.add(bancaDummy2);
        assertSame(list.get(0),bancaDummy1);
    }

    @Test
    public void testRange() {
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        for (int i = 0; i < list.size(); i++)
            if (i < 0 || i >= list.size())
                fail("Index error");
    }

    @Test
    public void whenListIsOfIntegerThenMaxCanBeDoneUsingIntegerComparator() {
        // given
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer expectedResult = 89;

        // then
        Integer max = listOfIntegers
                .stream()
                .mapToInt(v -> v)
                .max().orElseThrow(RuntimeException::new);

        assertEquals("Should be 89", expectedResult, max);
    }

    @Test
    public void testOrder() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("2");
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++)
            for (int j = i + 1; j < list.size(); j++)
                if (list.get(i).compareTo(list.get(j)) > 0)
                    fail("Order error 1");

    }
}
