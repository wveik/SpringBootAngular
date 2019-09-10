package ru.molcom.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "userr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private boolean enabled = true;

    @ManyToOne(targetEntity = PrimaryAccount.class)
    private PrimaryAccount primaryAccount;

    @ManyToOne(targetEntity = SavingsAccount.class)
    private SavingsAccount savingsAccount;

    @OneToMany(targetEntity=Appointment.class, fetch=FetchType.EAGER)
    private Set<Appointment> appointmentList;

    @OneToMany(targetEntity=Recipient.class, fetch=FetchType.EAGER)
    private Set<Recipient> recipientList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public PrimaryAccount getPrimaryAccount() {
        return primaryAccount;
    }

    public void setPrimaryAccount(PrimaryAccount primaryAccount) {
        this.primaryAccount = primaryAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public Set<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(Set<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public Set<Recipient> getRecipientList() {
        return recipientList;
    }

    public void setRecipientList(Set<Recipient> recipientList) {
        this.recipientList = recipientList;
    }
}
