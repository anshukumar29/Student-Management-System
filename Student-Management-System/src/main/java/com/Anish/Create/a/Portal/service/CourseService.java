package com.Anish.Create.a.Portal.service;

import com.Anish.Create.a.Portal.model.Course;
import com.Anish.Create.a.Portal.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;


    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course getCourseById(String id) {
        return courseRepo.findById(id).orElse(null);
    }

    public void saveCourse(Course course) {
        courseRepo.save(course);
    }

    public void updateCourse(String id, Course updatedCourse) {
        Course course = courseRepo.findById(id).orElse(null);
        if (course != null) {
            // Update course fields here
            course.setTitle(updatedCourse.getTitle());
            course.setDescription(updatedCourse.getDescription());
            course.setDuration(updatedCourse.getDuration());

            courseRepo.save(course);
        }
    }

    public void deleteCourse(String id) {
          courseRepo.deleteById(id);
    }
}
