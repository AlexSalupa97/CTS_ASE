package suite;

import categorii.Deposit;
import categorii.Withdraw;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import teste.BankAccountTest;

@RunWith(Categories.class)
@Suite.SuiteClasses(BankAccountTest.class)
//@Categories.IncludeCategory(Withdraw.class)
@Categories.ExcludeCategory(Withdraw.class)
public class CategoriiRunner {
}
