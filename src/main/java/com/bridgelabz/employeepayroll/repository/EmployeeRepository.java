/******************************************************************************
 *  Purpose: this interface is repository interface which can give service
 *  		 to use the implementation of JpaRepository this is the class
 *  		 which we are extending in this interface
 *
 *  @author  Megha Jagadale
 *  @version 1.0
 *  @since   10-10-2021
 *
 ******************************************************************************/
package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeData, Integer> {

    Optional<EmployeeData> findByName(String name);

    Optional<EmployeeData> findBySalary(long salary);
}
