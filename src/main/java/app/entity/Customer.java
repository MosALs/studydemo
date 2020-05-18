package app.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter @ToString @NoArgsConstructor
@Entity(name = "customer")
@Table(schema="dbo")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String fullName;

    @Column(name = "job")
    private String job;

    @Column(name = "age")
    private int age;

    @Column(name = "active")
    private String active;

    @Column(name = "phone_number")
    private int phoneNumber;



}
