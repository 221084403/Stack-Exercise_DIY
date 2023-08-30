/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.employeemanager;

import java.util.Stack;
import za.ac.tut.bl.EmployeeInterface;
import za.ac.tut.entities.Employee;

/**
 *
 * @author MNCEDISI
 */
public class EmployeeManager implements EmployeeInterface<Employee>
{
    private Stack<Employee> list;

    public EmployeeManager() 
    {
        list = new Stack<>();
    }

    @Override
    public Employee addEmployee(Employee employee)
    {
       return list.push(employee);
    }

    @Override
    public Stack<Employee> displayEmployees() 
    {
        return list;
    }

    @Override
    public Employee searchEmployee(Long idNumber) 
    {
        Employee employee = null;
        
        for (Employee display : list)
        {
            if(display.getIdNumber().equals(idNumber))
                employee = display;
        }
        
        return employee;
    }

    @Override
    public Employee removeEmployee() 
    {
        return list.pop();
    }

    @Override
    public Stack<Employee> retrenchCentainEmployees(Integer employeeNumOfRetrench)
    {
        Stack<Employee> theEmployee = new Stack<>();
        
        for (int i = 0; i < employeeNumOfRetrench; i++)
            theEmployee.push(list.get(i));
        
        return theEmployee;
    }

    @Override
    public boolean clearingOfEmployee() 
    {
        list.clear();
        
        if(list.empty())
            return true;
        else
            return false;
    }   
}
