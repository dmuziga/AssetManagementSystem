SELECT employee.username, employee_role.RoleDesc as authorities FROM employee, employee_role  
	WHERE employee.username = 'dmuziga' AND employee.Employee_RoleID = employee_role.RoleID