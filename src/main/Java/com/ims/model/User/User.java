package com.ims.model.User;
import com.ims.model.Policy.Policy;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="user")
public class User {

    @Id
    //@GeneratedValue annotations to indicate that this field is primary key and its value is auto generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String address;
    private String sex;
    private String email;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date dob;
    private String employment_status;
    private String risk_rate;
    private String role;

    @ManyToOne
    private Policy policy;


    public User() {
    }


    public User(String firstname, String lastname, String address, String sex, String email, Date dob, String employment_status, String risk_rate, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.sex = sex;
        this.email = email;
        this.dob = dob;
        this.employment_status = employment_status;
        this.risk_rate = risk_rate;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmployment_status() {
        return employment_status;
    }

    public void setEmployment_status(String employment_status) {
        this.employment_status = employment_status;
    }

    public String getRisk_rate() {
        return risk_rate;
    }

    public void setRisk_rate(String risk_rate) {
        this.risk_rate = risk_rate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
