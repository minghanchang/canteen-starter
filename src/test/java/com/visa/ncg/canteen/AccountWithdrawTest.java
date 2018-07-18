package com.visa.ncg.canteen;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.visa.ncg.canteen.model.Account;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AccountWithdrawTest {
    private Account acct;

    @Before
    public void setup () {
        acct = new Account();
    }

    @Test
    public void withdraw3DollarsFromAccountHaving7DollarsResultsIn4DollarBalance() throws Exception {
        acct.add(7);
        acct.withdraw(3);
        Assert.assertEquals(acct.getBalance(), 4);
        assertThatThrownBy(() -> { acct.withdraw(5); })
                .isInstanceOf(InvalidAmountException.class);

    }
}
