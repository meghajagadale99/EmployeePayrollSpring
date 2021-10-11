/******************************************************************************
 *  Purpose: Class is implemented for creating the POJO class
 *  		@Data, @Entity will tell the spring framework that this is POJO class
 *
 *  @author  Megha Jagadale
 *  @version 1.0
 *  @since   10-10-2021
 *
 ******************************************************************************/
package com.bridgelabz.employeepayroll.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class EmployeeData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String name;
    private long salary;
}
