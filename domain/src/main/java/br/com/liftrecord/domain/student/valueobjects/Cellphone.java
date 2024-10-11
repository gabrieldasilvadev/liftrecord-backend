package br.com.liftrecord.domain.student.valueobjects;

public class Cellphone {
    final String ddd;
    final String number;

    public Cellphone(String ddd, String number) {
        this.ddd = ddd;
        this.number = number;
    }

    public String getFullNumber() {
        return ddd + number;
    }
}
