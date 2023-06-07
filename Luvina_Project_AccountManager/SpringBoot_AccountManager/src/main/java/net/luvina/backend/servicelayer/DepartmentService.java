package net.luvina.backend.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.luvina.backend.datalayer.IDepartmentRepository;
import net.luvina.entity.Department;
import net.luvina.form.DepartmentFormForCreating;
import net.luvina.form.DepartmentFormForUpdate;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(int idInput) {

		return departmentRepository.findById(idInput).get();
	}

	@Override
	public void createDepartment(DepartmentFormForCreating form) {
		Department department = new Department(form.getName());

		departmentRepository.save(department);
	}

	@Override
	public void updateDepartmentById(int id, DepartmentFormForUpdate form) {
		Department department = getDepartmentById(id);
		department.setName(form.getName());

		departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentByName(String nameDep) {

		return departmentRepository.findByName(nameDep);
	}

	@Override
	public void deleteDepartmentById(int id) {
		departmentRepository.deleteById(id);

	}

}
