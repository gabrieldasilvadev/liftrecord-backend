package br.com.liftrecord.repositories;

import br.com.liftrecord.tables.AccountTable;
import io.micrometer.observation.ObservationFilter;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountTable, String> {
  Optional<AccountTable> findByEmail(String value);
}
