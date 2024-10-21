package br.com.liftrecord.repositories;

import br.com.liftrecord.tables.StudentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentTable, String> {
}
