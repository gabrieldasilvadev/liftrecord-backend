package br.com.liftrecord.entities.student;

import br.com.liftrecord.entities.student.valueobjects.Address;
import br.com.liftrecord.entities.student.valueobjects.BodyMetrics;
import br.com.liftrecord.entities.student.valueobjects.Cellphone;
import br.com.liftrecord.entities.student.valueobjects.Contact;
import br.com.liftrecord.entities.student.valueobjects.StudentId;
import br.com.liftrecord.entities.student.valueobjects.Email;

public class Student {
    private StudentId studentId;
    private String name;
    private Email email;
    private Cellphone cellphone;
    private Contact contact;
    private Address address;
    private BodyMetrics bodyMetrics;
}
