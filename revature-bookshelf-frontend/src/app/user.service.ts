import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import jwt_decode from 'jwt-decode';
import { User } from './_models/user';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  endpoint: string = 'http://localhost:9001';
  headers = new HttpHeaders().set('Content-Type', 'application/json');
  currentUser = {};


  userStream: BehaviorSubject<any> = new BehaviorSubject({})
  userName: string | null = null

  decodeToken() {
    let token = localStorage.getItem("token");
    if (token) {
      const decoded: any = jwt_decode(token);
      this.userName = decoded.sub;
    }
  }

  doLogin(credentials: any) {
    this.httpClient.post(`${this.endpoint}login`, credentials)
      .subscribe({
        next: (response: any) => {
          localStorage.setItem("token", response.jwt);
          const decoded: any = jwt_decode(response.jwt);
          this.userName = decoded.sub;
          this.userStream.next({
            action: "LOGIN_SUCCESS",
          })
        },
        error: (error => {
          this.userStream.next({
            action: "LOGIN_FAILED",
            error
          })
        })
      })
  }

  doLogout() {
    localStorage.removeItem('token')
    this.userStream.next({
      action: "LOGOUT_SUCCESS"
    });
  }

  isLoggedIn() {
    let token = localStorage.getItem("token");
    if (token) {
      return true;
    }
    else {
      return false;
    }
  }

  getToken() {
    let token = localStorage.getItem("token") || null
    return token;
  }

  doRegister(formData: any) {
    formData.authorities = [{
      authority:
        'ROLE_USER'
    }
    ]
    this.httpClient.post(`${this.endpoint}/api/users`, formData)
      .subscribe({
        next: (response: any) => {
          console.log(response)
          this.userStream.next({
            action: "REGISTER_SUCCESS",
          })
        }
      })
  }

  constructor(private httpClient: HttpClient) { }

  getUserProfile(id: any): Observable<any> {
    let api = `${this.endpoint}/user-profile/${id}`;
    return this.httpClient.get(api, { headers: this.headers }).pipe(
      map((response: any) => {
        const user = response as User;
        return user || {}
      }),
      catchError(this.handleError)
    )
  }



  // Error 
  handleError(error: HttpErrorResponse) {
    let msg = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      msg = error.error.message;
    } else {
      // server-side error
      msg = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(msg);
  }
}