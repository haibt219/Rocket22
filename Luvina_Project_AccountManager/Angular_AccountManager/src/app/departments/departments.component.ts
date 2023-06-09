import { Component } from '@angular/core';
import { Department } from '../models/Department';
import { DepartmentService } from '../department.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.css'],
})
export class DepartmentsComponent {
  public listDepartments: Department[] = [];
  constructor(
    private departmentService: DepartmentService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.departmentService.getDepartments().subscribe((data) => {
      console.log(data);
      this.listDepartments = data;
    });
  }

  public getListDepartments() {
    this.departmentService.getDepartments().subscribe((data) => {
      console.log(data);
      this.listDepartments = data;
    });
  }

  /**
   * Đường dẫn đến page addDepartment
   */
  public addDepartment() {
    this.router.navigate(['department-add-form']);
  }

  /**
   * deleteDepartment
   */
  public deleteDepartment(id: any) {
    console.log('account id: ' + id);
    this.departmentService.deleteDepartment(Number(id)).subscribe((data) => {
      console.log('You want delete: ' + data.name);
    });
    // this.getListDepartments();
  }

  /**
   * editDepartment
   */
  public editDepartment(id: any) {
    this.router.navigate(['department-update-form', id]);
  }
}
