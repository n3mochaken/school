package ru.hogwards.school.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.hogwards.school.model.Faculty;
import ru.hogwards.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service

public class StudentService {
    private final HashMap<Long, Student> studentMap = new HashMap<>();
    private long lastId = 0;

    public Student createStudent (Student student) {
        student.setId(lastId++);
        studentMap.put(lastId,student);
        return student;
    }

    public Student editStudent(Student student) {
        if (studentMap.containsKey(student.getId())){
            studentMap.put(student.getId(),student);
            return student;
        }
        return null;
    }
    public Student findStudent(long id) {
        return studentMap.get(id);
    }

    public Student deleteStudent(long id) {
        return studentMap.remove(id);
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

    public List<Student> getStudentsByAge(int age) {
        List<Student> studentsByAge = new ArrayList<>();
        for (Student student : studentMap.values()) {
            if (student.getAge() == age) {
                studentsByAge.add(student);
            }
        }
        return studentsByAge;
    }





}
