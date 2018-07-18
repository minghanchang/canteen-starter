package com.visa.ncg.canteen;

import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.visa.ncg.canteen.model.AccountResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountViewWebIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getReturnsViewWithAccountResponseInModel() throws Exception {
    mockMvc.perform(get("/account/1"))
        .andExpect(status().isOk())
        .andExpect(model().attributeExists("account"))
        .andExpect(model().attribute("account", instanceOf(AccountResponse.class)))
        .andExpect(view().name("account-view"));
  }
  
  @Test
  public void getOfNonExistentAccountReturns404() throws Exception {
    mockMvc.perform(get("/account/9999"))
           .andExpect(status().isNotFound());
  }

}