package br.com.liftrecord.repositories;

import br.com.liftrecord.tables.AccountTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountTable, String> {
}
