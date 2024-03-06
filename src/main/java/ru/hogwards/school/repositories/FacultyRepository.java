package ru.hogwards.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwards.school.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}
