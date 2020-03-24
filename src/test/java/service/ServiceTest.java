package service;

import domain.*;
import org.junit.Before;
import repository.*;
import org.junit.Assert;
import validation.*;

import java.util.Iterator;

public class ServiceTest {
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

    @org.junit.Test
    public void saveStudent0() {

        service.saveStudent("1", "Johnny", 923);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }
    @org.junit.Test
    public void saveStudent1() {

        service.saveStudent("", "Mary", 922);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }
    @org.junit.Test
    public void saveStudent2() {

        service.saveStudent(null, "Mary", 922);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }
    @org.junit.Test
    public void saveStudent3() {

        service.saveStudent("2", "", 922);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }
    @org.junit.Test
    public void saveStudent4() {

        service.saveStudent("3", null, 922);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }
    @org.junit.Test
    public void saveStudent5() {

        service.saveStudent("4", "Mary", 109);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }
    @org.junit.Test
    public void saveStudent6() {
        //Test fails cause apparently it doesn't take the boundary into consideration properly
        service.saveStudent("5", "Mary", 110);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(2, i);
    }
    @org.junit.Test
    public void saveStudent7() {

        service.saveStudent("6", "Mary", 111);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(3, i);
    }
    @org.junit.Test
    public void saveStudent8() {

        service.saveStudent("7", "Mary", 937);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(4, i);
    }
    @org.junit.Test
    public void saveStudent9() {

        service.saveStudent("8", "Mary", 938);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(5, i);
    }
    @org.junit.Test
    public void saveStudent10() {

        service.saveStudent("9", "Mary", 939);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(5, i);
    }
}