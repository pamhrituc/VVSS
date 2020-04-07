package service;

import domain.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import repository.*;
import org.junit.Assert;
import validation.*;

import java.util.Iterator;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTest {
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

    //Black Box testing for saveStudent (addStudent)
    @org.junit.Test
    public void saveStudent00() {

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
    public void saveStudent01() {

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
    public void saveStudent02() {

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
    public void saveStudent03() {

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
    public void saveStudent04() {

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
    public void saveStudent05() {

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
    public void saveStudent06() {
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
    public void saveStudent07() {

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
    public void saveStudent08() {

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
    public void saveStudent09() {

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
        while (studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(5, i);
    }
}