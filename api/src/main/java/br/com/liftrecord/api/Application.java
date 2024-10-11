package br.com.liftrecord.api;

import br.com.liftrecord.domain.student.Student;
import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        Student student = new Student();
        Micronaut.run(Application.class, args);
    }
}