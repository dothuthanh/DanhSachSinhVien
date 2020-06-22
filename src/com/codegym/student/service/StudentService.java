package com.codegym.student.service;

import com.codegym.student.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements IStudentService {
    private static Map<Integer, Student> students;
    static {
        students = new HashMap<>();
        students.put(1, new Student(1,"Nguyen Truong Bao","Thai Nguyen","bao@codegym.vn"));
        students.put(2, new Student(2, "Nguyen Truong Bao 2", "Thai Nguyen", "bao@codegym.vn" ));
        students.put(3, new Student(3, "Nguyen Truong Bao 3", "Thai Nguyen", "bao@codegym.vn" ));
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void save(Student student) {
        students.put(student.getId(), student);

    }

    @Override
    public Student findById(int id) {

        return students.get(id);
    }

    @Override
    public void update(int id, Student student) {
        students.put(id, student);

    }

    @Override
    public void remove(int id) {
        students.remove(id);

    }
}
