package br.com.empresa.services;

import br.com.empresa.entities.CustomerEntity;
import br.com.empresa.presenters.CustomerPresenter;
import br.com.empresa.repositories.CustomerRepository;
import br.com.empresa.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Transactional
    public CustomerPresenter insert(String firstName, String lastName, String birthday, String email) {
        CustomerEntity entity = new CustomerEntity(firstName, lastName, DateUtils.convertStringtoLocalDate(birthday), email);
        entity = this.repository.saveAndFlush(entity);
        return new CustomerPresenter(entity);
    }

    public List<CustomerPresenter> findAll() {
        List<CustomerEntity> entities = this.repository.findAll();
        if (entities.isEmpty() && entities != null)
            throw new RuntimeException("Não foi encontrado nenhum cliente");
        return entities.stream().map(a -> new CustomerPresenter(a)).collect(Collectors.toList());
    }

    public CustomerPresenter findById(long id) {
        return new CustomerPresenter(this.repository.findById(id).orElseThrow(
                () -> new RuntimeException("Não foi encontrado nenhum cliente")));
    }

    @Transactional
    public CustomerPresenter update(long id, String firstName, String lastName, String birthday, String email) {
        CustomerEntity entity = this.repository.findById(id).orElseThrow(
                () -> new RuntimeException("Customer not found"));
        return new CustomerPresenter(this.repository.saveAndFlush(entity));

    }

    @Transactional
    public void delete(long id) {
        this.repository.deleteById(id);
    }
}
