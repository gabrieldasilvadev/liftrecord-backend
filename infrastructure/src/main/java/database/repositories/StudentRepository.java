package database.repositories;

import database.tables.StudentTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentTable, String> {
}
