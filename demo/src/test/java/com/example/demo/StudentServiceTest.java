package com.example.demo;

import com.example.demo.db.ScoreRepository;
import com.example.demo.db.StudentRepository;
import io.vavr.collection.List;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    //    @Test
//    public void getStudents() {
//    }
    @Autowired
    private StudentRepository repository;

    @Test
    public void addStudent() {
        final StudentService service = new StudentService(repository, scoreRepository);
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        assertNotNull(created);
    }

    @Test
    public void addStudentIsReturned() {
        final StudentService service = new StudentService(repository, scoreRepository);
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final List<Student> all = service.getStudents();
        assertEquals("Student1", all.head().name);
    }

    @Test
    public void addStudentNewID() {
        final StudentService service = new StudentService(repository, scoreRepository);
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final Student created2 = service.addStudent(new NewStudent("Student2", "21-2-3", "IM"));

        final List<Student> all = service.getStudents();
        assertNotEquals(created.id, created2.id);
    }

    @Test
    public void getEmptyList() {
        final StudentService service = new StudentService(repository, scoreRepository);
        List<Student> students = service.getStudents();

        assertTrue(students.isEmpty());
    }
    @After
    public void cleanAfterTest() {
        this.repository.deleteAll();
    }

    @Autowired
    private ScoreRepository scoreRepository;

}