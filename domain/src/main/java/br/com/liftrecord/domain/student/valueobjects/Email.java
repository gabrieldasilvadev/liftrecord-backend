package br.com.liftrecord.domain.student.valueobjects;

public class Email {
    final String value;
    final String domain;

    public Email(String value) {
        this.value = value;
        domain = value.split("@")[1];
    }

    public String getDomain() {
        return domain;
    }
}
