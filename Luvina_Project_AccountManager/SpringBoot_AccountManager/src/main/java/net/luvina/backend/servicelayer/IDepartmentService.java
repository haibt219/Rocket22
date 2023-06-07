package net.luvina.backend.servicelayer;

import java.util.List;

import net.luvina.entity.Department;
import net.luvina.form.DepartmentFormForCreating;
import net.luvina.form.DepartmentFormForUpdate;

public interface IDepartmentService {
	public List<Department> getAllDepartment();

	public Department getDepartmentById(int idInput);

	public void createDepartment(DepartmentFormForCreating form);

	public void updateDepartmentById(int id, DepartmentFormForUpdate form);

	public Department getDepartmentByName(String nameDep);

	public void deleteDepartmentById(int id);
}
