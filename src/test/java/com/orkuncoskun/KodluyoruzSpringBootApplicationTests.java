package com.orkuncoskun;

import com.orkuncoskun.data.entity.EmployeeEntity;
import com.orkuncoskun.data.repository.EmployeeRepository;
import com.orkuncoskun.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KodluyoruzSpringBootApplicationTests implements TestCrud {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

    //CREATE
    @Test
    @Override
    public void testCreate() {
        EmployeeEntity employeeEntity = EmployeeEntity
                .builder()
                .firstName("Orkun Test")
                .lastName("Coskun Test")
                .emailId("coskunorkun1@gmail.com")
                .build();
        employeeRepository.save(employeeEntity);

        //nesne null ise assertionError hatasını göndersin
        //1. kayda göre verileri getir
        assertNotNull(employeeRepository.findById(1L).get());
    }

    //LIST
    @Test
    @Override
    public void testList() {
        List<EmployeeEntity> list = employeeRepository.findAll();

        //eğer Sıfırdan büyükse liste vardır
        assertThat(list).size().isGreaterThan(0);
    }

    //FINDBYID
    @Test
    @Override
    public void testFindById() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();

        //Orkun Test adında kayıt var mı yok mu
        assertEquals("Orkun Test", employeeEntity.getFirstName());
    }

    //UPDATE
    @Test
    @Override
    public void testUpdate() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        employeeEntity.setFirstName("Orkun 55 Test");
        employeeRepository.save(employeeEntity);
        //Eşit değilse bir sorun olmayacak ama eşitse exception fırlatsın
        assertNotEquals("Orkun Test", employeeRepository.findById(1L).get().getFirstName());
    }

    //DELETE
    @Test
    @Override
    public void testDelete() {
        employeeRepository.deleteById(1L);
        //isFalse
        assertThat(employeeRepository.existsById(1L)).isFalse();
    }
}
