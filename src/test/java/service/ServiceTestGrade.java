package service;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Assert;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import java.util.Iterator;

public class ServiceTestGrade {
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
    @org.junit.Test
    public void addAssignment1() {
        service.saveTema("10", "description", 12, 8);
        int i = 0;
        Iterator assignmentsIterator = service.findAllStudents().iterator();
        while(assignmentsIterator.hasNext()) {
            i++;
            assignmentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }
    @org.junit.Test
    public void saveStudent1() {
        service.saveStudent("5", "Steve", 923);
        int i = 0;
        Iterator studentsIterator = service.findAllTeme().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }
    @org.junit.Test
    public void addGrade1()
    {
        service.saveNota("5", "10", 9, 12, "yeet");
        int i = 0;
        Iterator gradesIterator = service.findAllNote().iterator();
        while(gradesIterator.hasNext()) {
            i++;
            gradesIterator.next();
        }
        Assert.assertEquals(1, i);
    }
    @org.junit.Test
    public void testGrade()
    {
        addAssignment1();
        saveStudent1();
        addGrade1();
    }

}
