package br.com.empresa.repositories;

import br.com.empresa.Application;
import br.com.empresa.entities.CustomerEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerRespositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        CustomerEntity entity = repository.save(new CustomerEntity("eduardo", "lopes",
                LocalDate.parse("1988-02-13", DateTimeFormatter.ISO_LOCAL_DATE), "dalhkedu@gmail.com"));

        CustomerEntity foundEntity = repository.findById(entity.getCustomerId()).get();

        assertNotNull(foundEntity);
        assertEquals(entity.getFirstName(), foundEntity.getFirstName());
    }
}
