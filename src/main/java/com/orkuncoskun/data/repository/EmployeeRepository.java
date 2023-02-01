package com.orkuncoskun.data.repository;

import com.orkuncoskun.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//JpaRepository > CrudRepository
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
