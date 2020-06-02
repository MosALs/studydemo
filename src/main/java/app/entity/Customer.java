package app.entity;


import jdk.nashorn.internal.objects.annotations.Getter;


import javax.persistence.*;

//@Setter @ToString @NoArgsConstructor
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
