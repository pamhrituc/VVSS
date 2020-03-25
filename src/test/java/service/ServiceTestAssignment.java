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

    //White Box testing for addAssignment (saveTema method from the Service class
    @org.junit.Test
    public void addAssignment00() {
        int result = service.saveTema("2", "description", 4, 8);
        int i = 0;
        Iterator assignmentsIterator = service.findAllTeme().iterator();
        while(assignmentsIterator.hasNext()) {
            i++;
            assignmentsIterator.next();
        }
        System.out.println(i);
        Assert.assertEquals(1, result);
    }
    @org.junit.Test
    public void addAssignment01() {
        int result = service.saveTema("", "description", 4, 8);
        Assert.assertEquals(1, result);
    }
}
