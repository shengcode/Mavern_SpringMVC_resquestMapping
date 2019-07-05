package com.ibm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/store")
public class EmployeeController {
	@RequestMapping(method=RequestMethod.POST)
	public String saveEmployee(Model model, Employee employee){		
		System.out.println("eno: "+employee.getEno());
		System.out.println("name: "+employee.getName());
		System.out.println("salary: "+employee.getSalary());
		model.addAttribute(employee);
		getConnection ();
		return "display";
	}
	
	public void getConnection (){
		System.out.println("connected or not");
		Connection myOracleConnection;
		try{
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	       }
	        catch (ClassNotFoundException ex) {
	                System.out.println("Exception:"+ex.getMessage());
	         }
	        try{
	            myOracleConnection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Student_Performance","Student_Performance");
	        }               
	     
	        catch (SQLException ex){
	            System.out.println("Exception:"+ex.getMessage());
	            
	        }
	        
	        System.out.println("conenction done!!");
	}
	
}
