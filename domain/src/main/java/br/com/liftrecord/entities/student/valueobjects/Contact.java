package br.com.liftrecord.entities.student.valueobjects;

public class Contact {
    final Email email;
    final Cellphone cellphone;

    public Contact(Email email, Cellphone cellphone) {
        this.email = email;
        this.cellphone = cellphone;
    }
}
