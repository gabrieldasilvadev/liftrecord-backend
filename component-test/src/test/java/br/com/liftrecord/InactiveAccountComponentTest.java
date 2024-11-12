package br.com.liftrecord;

import br.com.liftrecord.account.Account;
import br.com.liftrecord.factory.AccountFactory;
import br.com.liftrecord.repositories.AccountRepository;
import br.com.liftrecord.tables.AccountTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;

public class InactiveAccountComponentTest  extends BaseComponentTest{

  @Autowired
  private AccountRepository accountRepository;

  @Test
  @DisplayName("Given a valid request, When DELETE /api/v1/accounts/{account_id}, Then return status 204 (No Content) Student removed")
  void testRemoveStudentStatusNoContent() {
    Account accountStub = AccountFactory.createAccount();
    accountRepository.save(AccountTable.fromDomain(accountStub));
    accountRepository.findById(accountStub.getId().getValue());

    given()
        .when()
        .pathParam("account_id", accountStub.getId().getValue())
        .delete("/api/v1/accounts/{account_id}")
        .then()
        .statusCode(204);
  }
}
