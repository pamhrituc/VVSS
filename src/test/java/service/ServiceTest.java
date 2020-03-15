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

        service.saveStudent("2", "Mary", 922);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(2, i);
    }
}