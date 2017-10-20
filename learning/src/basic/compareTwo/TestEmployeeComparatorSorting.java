package basic.compareTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class TestEmployeeComparatorSorting {  
 public static void main(String[] args) {  
  EmployeePojo e1 = new EmployeePojo(1,"A",20000.00,new Date(2010,12,11));  
  EmployeePojo e2 = new EmployeePojo(2,"A",22000.00,new Date(2009,12,11));  
  EmployeePojo e3 = new EmployeePojo(3,"A",10000.00,new Date(1990,12,11));  
  EmployeePojo e4 = new EmployeePojo(4,"F",19000.00,new Date(2001,12,11));  
  EmployeePojo e5 = new EmployeePojo(5,"E",24000.00,new Date(2006,12,11));  
  List<EmployeePojo> list = new ArrayList<EmployeePojo>();  
  list.add(e1);list.add(e2);list.add(e3);list.add(e4);list.add(e5);  
  
  Collections.sort(list,new EmployeeNameComparator());  
  // PRINT AFTER SORTED BY NAME  
  System.out.println("AFTER SORTED BY NAME");  
  System.out.println("===============================================================");  
  System.out.println("ID  Name  Salary  Date Of Joining");  
  System.out.println("===============================================================");  
  for (EmployeePojo employee : list) {  
   System.out.println(employee.getEmpId()+"\t\t "+employee.getName()  
     +"\t\t"+employee.getSalary()+"\t\t "+  
     employee.getDateOfJoining().getDay()+"-"+employee.getDateOfJoining().getMonth()  
     +"-"+employee.getDateOfJoining().getYear());  
  }  
  
  // sorting the EmployeePojo object  
  
  Collections.sort(list,new EmployeeDOJComparator());  
  
  // PRINT AFTER SORTED BY AGE  
  System.out.println("AFTER SORTED BY DATE OF JOINING");  
  System.out.println("===============================================================");  
  System.out.println("ID  Name  Salary  Date Of Joining");  
  System.out.println("===============================================================");  
  for (EmployeePojo employee : list) {  
   System.out.println(employee.getEmpId()+"\t\t "+employee.getName()  
     +"\t\t"+employee.getSalary()+"\t\t "+  
     employee.getDateOfJoining().getDay()+"-"+employee.getDateOfJoining().getMonth()  
     +"-"+employee.getDateOfJoining().getYear());  
  }  
 }  
}
