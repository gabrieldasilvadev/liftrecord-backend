package br.com.liftrecord.domain.student.valueobjects;

public class Contact {
    final Email email;
    final Cellphone cellphone;

    public Contact(Email email, Cellphone cellphone) {
        this.email = email;
        this.cellphone = cellphone;
    }
}
