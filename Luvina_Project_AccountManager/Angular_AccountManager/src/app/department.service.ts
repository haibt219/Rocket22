import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Department } from './models/Department';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class DepartmentService {
  private REST_API_SERVER_DEPARTMENT =
    'http://localhost:8080/api/v1/departments';

  constructor(private httpClient: HttpClient) {}

  public getDepartments(): Observable<any> {
    const url = this.REST_API_SERVER_DEPARTMENT;
    return this.httpClient
      .get<any>(url, httpOptions)
      .pipe(catchError(this.handleError));
  }

  public getDepartmentById(id: number): Observable<any> {
    const url = this.REST_API_SERVER_DEPARTMENT + '/' + id;
    return this.httpClient
      .get<any>(url, httpOptions)
      .pipe(catchError(this.handleError));
  }

  public addDepartment(data: Department): Observable<any> {
    const url = this.REST_API_SERVER_DEPARTMENT;
    return this.httpClient
      .post<any>(url, data, httpOptions)
      .pipe(catchError(this.handleError));
  }

  public deleteDepartment(depId: number): Observable<any> {
    const url = this.REST_API_SERVER_DEPARTMENT + '/' + depId;
    return this.httpClient.delete<any>(url).pipe(catchError(this.handleError));
  }

  public updateDepartment(id: number, data: Department): Observable<any> {
    const url = this.REST_API_SERVER_DEPARTMENT + '/' + id;
    return this.httpClient
      .put<any>(url, data, httpOptions)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` + `body was: ${error.error}`
      );
    }
    return throwError('St bad happend; plz try again later.');
  }
}
