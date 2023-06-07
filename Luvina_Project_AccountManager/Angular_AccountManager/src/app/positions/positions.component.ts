import { Component } from '@angular/core';
import { Position } from '../models/Position';
import { PositionService } from '../position.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-positions',
  templateUrl: './positions.component.html',
  styleUrls: ['./positions.component.css'],
})
export class PositionsComponent {
  public listPositions: Position[] = [];
  constructor(
    private positionService: PositionService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.positionService.getPositions().subscribe((data) => {
      console.log(data);
      this.listPositions = data;
    });
  }

  public getListPositions() {
    this.positionService.getPositions().subscribe((data) => {
      console.log(data);
      this.listPositions = data;
    });
  }

  /**
   * Đường dẫn đến page addPosition
   */
  public addPosition() {
    this.router.navigate(['department-add-form']);
  }

  /**
   * deletePosition
   */
  public deleteDepartment(id: any) {
    console.log('position id: ' + id);
    this.positionService.deletePosition(Number(id)).subscribe((data) => {
      alert('You want delete: ' + data.name);
    });
    this.getListPositions();
  }

  /**
   * editPosition
   */
  public editDepartment(id: any) {
    this.router.navigate(['account-update-form', id]);
  }
}
