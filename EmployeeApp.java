/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeapp;

import java.util.*;
import za.ac.tut.employeemanager.*;
import za.ac.tut.entities.Employee;

/**
 *
 * @author MNCEDISI
 */
public class EmployeeApp 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        EmployeeManager em = new EmployeeManager();
        Employee employee = null;
        
        int option = displayOptions();
        
        do
        {
            switch(option)
            {
                case 1:
                    employee = creatingEmployee();
                    
                    employee = em.addEmployee(employee);
                    
                    if(employee==null)
                        System.err.println("Employee is not add\n");
                    else
                        System.out.println("Employee is add\n");
                break;
                    
                case 2:
                    Stack<Employee> list = em.displayEmployees();
                    
                    if(!list.empty())
                        displayEmployees(list);
                    else
                        System.err.println("The is nothing in the list");
                break;
                    
                case 3:
                    Long idNumber = employeeIDNumber();
                   
                    employee = em.searchEmployee(idNumber);
                    
                    if(employee!=null)
                        displayEmployee(employee);
                    else
                        System.err.println("Employee "+idNumber+" is not found");             
                break;
                    
                case 4:
                    employee = em.removeEmployee();
                    
                    if(employee!=null)
                    {
                        displayEmployee(employee);
                        System.out.println("Employee is removed");
                    }
                    else
                        System.err.println("Employee is not found");
                break;
                    
                case 5:
                    Integer numOfEmployee = numberOfEmployeesNeeded();
                    
                    list = em.retrenchCentainEmployees(numOfEmployee);
                    
                    if(!list.empty())
                        displayEmployees(list);
                    else
                        System.err.println("The is nothing in the list");
                break;
                    
                case 6:
                    if(em.clearingOfEmployee())
                        System.out.println("Clearing employeess was successfully");
                    else
                        System.err.println("Nothing was found in the list (it's clean)");
                break;
                    
                default:
                    System.err.println("Invalid option. Please re-enter ");
                break;
                    
            }
            
            option = displayOptions();
        }
        while(option!=7);
    } 

    private static int displayOptions()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("");
        String menu = "Please select one of the following option :\n\n"+
                      "1. Add employees to a list\n"+
                      "2. Display all the employees\n"+
                      "3. Search for a specific employee using an ID number\n"+
                      "4. Remove an employee from the list\n"+
                      "5. Retrench a certain number of employees using the LIFO principle\n"+
                      "6. Retrench all the employees by clearing the list\n"+
                      "7. Exit\n\n"+
                      "Your option :";
        System.out.print(menu);
        
        return sc.nextInt();
    }

    private static Employee creatingEmployee() 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("");
        
        System.out.print("Enter your ID Number\t:");
        Long idNumber = sc.nextLong();
        
        sc.nextLine();
        
        System.out.print("Enter your Name\t\t:");
        String name = sc.nextLine();
        
        return new Employee(idNumber, name);
    }

    private static void displayEmployees(Stack<Employee> list) 
    {
        for (Employee display : list) 
        {
            Long idNumber = display.getIdNumber();
            String name = display.getName();
            
            String output = "ID Number\t:"+idNumber+"\n"+
                            "Name\t\t:"+name+"\n";
            
            System.out.println(output);
        }
    }

    private static Long employeeIDNumber() 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nPlease enter the ID Number of the employee you want to view :");
       
        return sc.nextLong();
    }

    private static void displayEmployee(Employee employee) 
    {
        String output = "\nID Number\t:"+employee.getIdNumber()+
                        "\nName\t\t:"+employee.getName();
        
        System.out.println(output);
    }

    private static Integer numberOfEmployeesNeeded() 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nPlease enter number of employees you want to see[LIFO] in the list :");
        
        return sc.nextInt();
    }
}
