package database.repositories;

import database.tables.StudentTable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<StudentTable, String> {
}
