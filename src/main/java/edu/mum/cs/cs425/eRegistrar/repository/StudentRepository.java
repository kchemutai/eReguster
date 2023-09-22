package edu.mum.cs.cs425.eRegistrar.repository;

import edu.mum.cs.cs425.eRegistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
