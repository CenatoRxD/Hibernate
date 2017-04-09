package entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sviatoslav on 09.04.2017.
 */
@Entity()
@DynamicUpdate
@DynamicInsert
public class Users implements Serializable{

    @Id()
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "User_Name")
    private String name;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Age")
    private int age;

    @Column(name = "Address")
    private String address;

    public Users() {
    }

    public Users(String name, String lastName, int age, String address) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (age != users.age) return false;
        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        if (lastName != null ? !lastName.equals(users.lastName) : users.lastName != null) return false;
        return address != null ? address.equals(users.address) : users.address == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "Name: " + name +
                ", Last Name: " + lastName +
                ", Age: " + age +
                ", Address:" + address;
    }
}
