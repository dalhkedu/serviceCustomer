package br.com.empresa.parameters;

import br.com.empresa.Application;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerParameterTest {


    private static Validator validator;

    @Before
    public void validacao_dos_parametros() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void valida_todos_parametros_preenchidos_do_construtor() {
        CustomerParameter parameter = new CustomerParameter("João", "Silva", "13-02-1988", "joao@gmail.com");
        Set<ConstraintViolation<CustomerParameter>> violations = validator.validate(parameter);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void valida_se_valor_do_email_esta_incorreto() {
        CustomerParameter parameter = new CustomerParameter("João", "Silva", "13-02-1988", "joao");
        Set<ConstraintViolation<CustomerParameter>> violations = validator.validate(parameter);
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void valida_se_valor_do_email_esta_incorreto_se_tem_campos_nullos_e_vazio() {
        CustomerParameter parameter = new CustomerParameter("", null, "13-02-1988", "joao");
        Set<ConstraintViolation<CustomerParameter>> violations = validator.validate(parameter);
        assertThat(violations.size()).isEqualTo(3);
    }
}
