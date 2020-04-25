package br.com.empresa.parameters;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

public class CustomerParameter implements Serializable {

    @NotEmpty(message = "Preencher")
    private String firstName;

    @NotEmpty(message = "Preencher")
    private String lastName;


    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    @NotEmpty(message = "Preencher")
    private String birthday;

    @Email
    @NotEmpty(message = "Preencher")
    private String email;

    public CustomerParameter(String firstName, String lastName, String birthday, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerParameter that = (CustomerParameter) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday, email);
    }

    @Override
    public String toString() {
        return "CustomerParameter{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
