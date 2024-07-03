package com.Anish.Create.a.Portal.repository;

import com.Anish.Create.a.Portal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,String> {
}
