import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Account } from './models/Account';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class AccountsService {
  private REST_API_SERVER_ACCOUNT = 'http://localhost:8080/api/v1/accounts';

  constructor(private httpClient: HttpClient) {}

  public getAccounts(): Observable<any> {
    const url = this.REST_API_SERVER_ACCOUNT;
    return this.httpClient
      .get<any>(url, httpOptions)
      .pipe(catchError(this.handleError));
  }

  public getAccountById(id: number): Observable<any> {
    const url = this.REST_API_SERVER_ACCOUNT + '/' + id;
    return this.httpClient
      .get<any>(url, httpOptions)
      .pipe(catchError(this.handleError));
  }

  public addAccount(data: Account): Observable<any> {
    const url = this.REST_API_SERVER_ACCOUNT;

    return this.httpClient
      .post<any>(url, data, httpOptions)
      .pipe(catchError(this.handleError));
  }

  public deleteAccount(accountId: number): Observable<any> {
    const url = this.REST_API_SERVER_ACCOUNT + '/' + accountId;
    return this.httpClient.delete<any>(url).pipe(catchError(this.handleError));
  }

  public updateAccount(id: number, data: Account): Observable<any> {
    const url = this.REST_API_SERVER_ACCOUNT + '/' + id;
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
