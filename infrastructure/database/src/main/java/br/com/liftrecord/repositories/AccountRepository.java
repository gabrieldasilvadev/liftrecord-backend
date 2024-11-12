package br.com.liftrecord.repositories;

import br.com.liftrecord.tables.AccountTable;
import jakarta.persistence.QueryHint;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

public interface AccountRepository extends JpaRepository<AccountTable, String> {
  @QueryHints(value = {
      @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
      @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE")
  })
  boolean existsByEmail(String value);

  @QueryHints({
      @QueryHint(name = "jakarta.persistence.lock.timeout", value = "2000")
  })
  Optional<AccountTable> findById(@NotNull String value);
}
