package com.example.demo;

import io.vavr.collection.List;
import org.junit.Test;


import static org.junit.Assert.*;

public class StudentServiceTest {
    @Test
public void GetEmptyList()
    {
        final StudentService service=new StudentService();
        List<Student> testList= service.getStudents();
        assertTrue(testList.isEmpty());
    }
    @Test
    public void AddStudentTest(){
        final StudentService service=new StudentService();
        final Student created = service.addStudents(new NewStudent("PierwszyStudent","1-2-3","Pierwsza"));
        assertNotNull(created);
    }
    @Test
    public void AddStudentIsReturned(){
        final StudentService service=new StudentService();
        final Student created = service.addStudents(new NewStudent("PierwszyStudent","1-2-3","Pierwsza"));
        final List<Student> all = service.getStudents();
        assertEquals(created.Name,all.head().Name);
    }
    @Test
    public void AddStudentHasNewId(){
        final StudentService service=new StudentService();
        final Student created = service.addStudents(new NewStudent("PierwszyStudent","1-2-3","Pierwsza"));
        final Student created2 = service.addStudents(new NewStudent("DrugiStudent","1-2-3","Pierwsza"));
        assertEquals(2,service.getStudents().size());
        assertNotEquals(created.ID,created2.ID);
    }
}