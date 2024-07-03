package com.Anish.Create.a.Portal.service;

import com.Anish.Create.a.Portal.model.Student;
import com.Anish.Create.a.Portal.repository.AddressRepo;
import com.Anish.Create.a.Portal.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepo.findById(id).orElse(null);
    }

    public void saveStudent(Student student) {
          studentRepo.save(student);
    }

    public void updateStudent(String id, Student updatedStudent) {
        Student student = studentRepo.findById(id).orElse(null);
        if (student != null) {
            // Update student fields here
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setPhoneNumber(updatedStudent.getPhoneNumber());
            student.setBranch(updatedStudent.getBranch());
            student.setDepartment(updatedStudent.getDepartment());

            studentRepo.save(student);
        }
    }

    public void deleteStudent(String id) {
        studentRepo.deleteById(id);
    }
}
