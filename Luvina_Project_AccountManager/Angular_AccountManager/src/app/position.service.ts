import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Position } from './models/Position';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class PositionService {
  private REST_API_SERVER_POSITION = 'http://localhost:8080/api/v1/positions';

  constructor(private httpClient: HttpClient) {}

  public getPositions(): Observable<any> {
    const url = this.REST_API_SERVER_POSITION;
    return this.httpClient
      .get<any>(url, httpOptions)
      .pipe(catchError(this.handleError));
  }

  public getPositionById(id: number): Observable<any> {
    const url = this.REST_API_SERVER_POSITION + '/' + id;
    return this.httpClient
      .get<any>(url, httpOptions)
      .pipe(catchError(this.handleError));
  }

  public addPosition(data: Position): Observable<any> {
    const url = this.REST_API_SERVER_POSITION;
    return this.httpClient
      .post<any>(url, data, httpOptions)
      .pipe(catchError(this.handleError));
  }

  public deletePosition(posId: number): Observable<any> {
    const url = this.REST_API_SERVER_POSITION + '/' + posId;
    return this.httpClient.delete<any>(url).pipe(catchError(this.handleError));
  }

  public updatePosition(id: number, data: Position): Observable<any> {
    const url = this.REST_API_SERVER_POSITION + '/' + id;
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
