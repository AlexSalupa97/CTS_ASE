package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import teste.BankAccountTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(BankAccountTest.class)
public class SuiteRunner {
}
