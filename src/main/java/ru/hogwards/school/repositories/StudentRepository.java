package ru.hogwards.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwards.school.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
