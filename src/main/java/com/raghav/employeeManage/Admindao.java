/**
 * 
 */
package com.raghav.employeeManage;

import java.util.List;

public interface Admindao 

{

	
	// call methods of admindaoImpl
	
	public Employee getEmployee(int userid);
	public List<Employee>getAllEmployee(); 
	public int insertemployee(Employee emp); 
	public int updateemployee(Employee emp);
	public int deleteemployee(int userid);
	
}
