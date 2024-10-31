package br.com.liftrecord.ports.account;

import br.com.liftrecord.account.Account;

public interface SaveAccountOutputPort {
  Account save(final Account account);
}
