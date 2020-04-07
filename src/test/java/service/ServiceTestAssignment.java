package service;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import java.util.Iterator;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTestAssignment {
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

    //White Box testing for addAssignment (saveTema) method from the Service class
    @org.junit.Test
    public void addAssignment00() {
        int result = service.saveTema("0", "description", 4, 8);
        Assert.assertEquals(1, result);
    }
    @org.junit.Test
    public void addAssignment01() {
        int result = service.saveTema("", "description", 8, 4);
        Assert.assertEquals(1, result);
    }
    @org.junit.Test
    public void addAssignment02() {
        int result = service.saveTema(null, "description", 8, 4);
        Assert.assertEquals(1, result);
    }
    @org.junit.Test
    public void addAssignment03() {
        int result = service.saveTema("1", "", 8, 4);
        Assert.assertEquals(1, result);
    }
    @org.junit.Test
    public void addAssignment04() {
        int result = service.saveTema("1", null, 8, 4);
        Assert.assertEquals(1, result);
    }
    @org.junit.Test
    public void addAssignment05() {
        int result = service.saveTema("1", "description", 0, 4);
        Assert.assertEquals(1, result);
    }
    @org.junit.Test
    public void addAssignment06() {
        int result = service.saveTema("1", "description", 15, 4);
        Assert.assertEquals(1, result);
    }
    @org.junit.Test
    public void addAssignment07() {
        int result = service.saveTema("1", "description", 3, 0);
        Assert.assertEquals(1, result);
    }
    @org.junit.Test
    public void addAssignment08() {
        int result = service.saveTema("1", "description", 3, 15);
        Assert.assertEquals(1, result);
    }
}
