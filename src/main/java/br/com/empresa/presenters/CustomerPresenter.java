package br.com.empresa.presenters;

import br.com.empresa.entities.CustomerEntity;

import java.io.Serializable;

public class CustomerPresenter implements Serializable {

    private long id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String email;

    public CustomerPresenter(CustomerEntity entity) {
        this.id = entity.getCustomerId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.birthday = entity.getBirthday().toString();
        this.email = entity.getEmail();
    }
}
