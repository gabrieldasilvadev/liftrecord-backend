package br.com.liftrecord.domain.student;

import br.com.liftrecord.domain.student.valueobjects.Address;
import br.com.liftrecord.domain.student.valueobjects.BodyMetrics;
import br.com.liftrecord.domain.student.valueobjects.Cellphone;
import br.com.liftrecord.domain.student.valueobjects.Contact;
import br.com.liftrecord.domain.student.valueobjects.StudentId;
import br.com.liftrecord.domain.student.valueobjects.Email;

public class Student {
    private StudentId studentId;
    private String name;
    private Email email;
    private Cellphone cellphone;
    private Contact contact;
    private Address address;
    private BodyMetrics bodyMetrics;
}
