/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.util.*;

/**
 *
 * @author MNCEDISI
 * @param <T>
 */
public interface EmployeeInterface<T> 
{
    public T addEmployee(T employee);
    
    public Stack<T> displayEmployees();
    
    public T searchEmployee(Long idNumber);
    
    public T removeEmployee();
    
    public Stack<T> retrenchCentainEmployees(Integer employeeNumOfRetrench);
    
    public boolean clearingOfEmployee();
}
