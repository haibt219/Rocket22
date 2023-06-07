package net.luvina.backend.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import net.luvina.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

	public Department findByName(String name);

}
