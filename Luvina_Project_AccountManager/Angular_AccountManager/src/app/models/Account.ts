import { Department } from './Department';
import { Position } from './Position';

export interface Account {
  id: number;
  email: string;
  userName: number;
  fullName: string;
  department: Department;
  position: Position;
  createDate: Date;
}
