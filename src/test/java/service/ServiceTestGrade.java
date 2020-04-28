package service;

import domain.Nota;
import domain.Pair;
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

import java.util.ArrayList;
import java.util.Iterator;

public class ServiceTestGrade {
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

    public void deleteAllA()
    {
        ArrayList<String> ida = new ArrayList();
        service.findAllTeme().forEach(assignment -> ida.add(assignment.getID()));
        for (int i = 0; i < ida.size(); i++) {
            service.deleteTema(ida.get(i));
        }
    }
    public void deleteAllS() {
        ArrayList<String> ids = new ArrayList();
        service.findAllStudents().forEach(student -> ids.add(student.getID()));
        for (int i = 0; i < ids.size(); i++) {
            service.deleteStudent(ids.get(i));
        }
    }

    public void deleteAllG()
    {
        ArrayList<Pair<String, String>> idg = new ArrayList();
        service.findAllNote().forEach(grade -> idg.add(grade.getID()));
        for (int i = 0; i < idg.size(); i++)
        {
            service.deleteNota(idg.get(i));
        }
    }

    //used black box testing
    @org.junit.Test
    public void addAssignment1() {
        deleteAllA();

        service.saveTema("10", "description", 12, 8);
        int i = 0;
        Iterator assignmentsIterator = service.findAllTeme().iterator();
        while(assignmentsIterator.hasNext()) {
            i++;
            assignmentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void saveStudent1() {
        deleteAllS();
        service.saveStudent("10", "Steve", 923);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }
    @org.junit.Test
    public void addGrade1()
    {
        deleteAllG();
        service.saveNota("10", "10", 9, 12, "yeet");
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

    @org.junit.Test
    public void addStudent2()
    {
        deleteAllS();
        service.saveStudent("7", "Jack", 923);
        int i = 0;
        Iterator studentsIterator = service.findAllStudents().iterator();
        while(studentsIterator.hasNext()) {
            i++;
            studentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void addAssignment2()
    {
        addStudent2();
        deleteAllA();

        service.saveTema("7", "An assignment", 10, 8);
        int i = 0;
        Iterator assignmentsIterator = service.findAllTeme().iterator();
        while(assignmentsIterator.hasNext()) {
            i++;
            assignmentsIterator.next();
        }
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void addGrade2()
    {
        addStudent2();
        addAssignment2();
        deleteAllG();
        service.saveNota("7", "7", 9, 12, "yoink");
        int i = 0;
        Iterator gradesIterator = service.findAllNote().iterator();
        while(gradesIterator.hasNext()) {
            i++;
            gradesIterator.next();
        }
        Assert.assertEquals(1, i);
    }
}
