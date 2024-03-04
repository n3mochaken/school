package ru.hogwards.school.services;

import org.springframework.stereotype.Service;
import ru.hogwards.school.model.Faculty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
@Service

public class FacultyService {
    private final HashMap<Long, Faculty> facultyMap = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty (Faculty faculty) {
        faculty.setId(lastId++);
        facultyMap.put(lastId,faculty);
        return faculty;
    }

    public Faculty editFaculty(Faculty faculty) {
        if (facultyMap.containsKey(faculty.getId())){
            facultyMap.put(faculty.getId(),faculty);
            return faculty;
        }
        return null;
    }
    public Faculty findFaculty(long id) {
        return facultyMap.get(id);
    }

    public Faculty deleteFaculty(long id) {
        return facultyMap.remove(id);
    }

    public Collection<Faculty> getAllFaculty() {
        return facultyMap.values();
    }

    public List<Faculty> getFacultyByColor(String color) {
        List<Faculty> facultyByColor = new ArrayList<>();
        for (Faculty faculty : facultyMap.values()) {
            if (faculty.getColor() == color) {
                facultyByColor.add(faculty);
            }
        }
        return facultyByColor;
    }
}
