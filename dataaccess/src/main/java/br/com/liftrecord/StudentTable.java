package br.com.liftrecord;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "students")
public class StudentTable {
    @Id
    private String id;
    private String name;
    private String email;
    private String cellphone;
    @OneToOne
    private AddressTable addressTable;
    @OneToOne
    private BodyMetricsTable bodyMetricsTable;
}
