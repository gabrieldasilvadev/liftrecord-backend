package br.com.liftrecord.repositories;

import br.com.liftrecord.tables.StudentTable;
import jakarta.persistence.QueryHint;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentTable, String> {
  @QueryHints({
      @QueryHint(name = "jakarta.persistence.lock.timeout", value = "2000")})
  Optional<StudentTable> findById(@NotNull String accountId);
}
