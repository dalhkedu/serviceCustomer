package br.com.empresa.controllers;

import br.com.empresa.parameters.CustomerParameter;
import br.com.empresa.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity insert(@RequestBody CustomerParameter parameter) {
        this.service.insert(parameter.getFirstName(), parameter.getLastName(), parameter.getBirthday(), parameter.getEmail());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathParam(value = "id") long id) {
        return ResponseEntity.ok(this.service.findById(id));
    }

    @PutMapping
    public ResponseEntity update(@PathParam(value = "id") long id, @RequestBody CustomerParameter parameter) {
        this.service.update(id, parameter.getFirstName(), parameter.getLastName(), parameter.getBirthday(), parameter.getEmail());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity delete(@PathParam(value = "id") long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
