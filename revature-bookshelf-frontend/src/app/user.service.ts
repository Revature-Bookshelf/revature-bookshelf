import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import jwt_decode from 'jwt-decode'; 

@Injectable({
    providedIn: 'root'
})

export class UserService {

    userStream: BehaviorSubject<any> = new BehaviorSubject({})
    userName: string | null = null

    decodeToken() {
        let token = localStorage.getItem("token");
        if(token) {
            const decoded: any = jwt_decode(token);
            this.userName = decoded.sub;
        }
    }

    doLogin(credentials: any) {
        this.httpClient.post("http://localhost:4200/login", credentials)
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
        if(token) {
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
        formData.authorities = [
          'ROLE_USER'
        ]
        this.httpClient.post("http://localhost:4200/bookshelf/user", formData)
          .subscribe({
            next: (response: any) => {
              this.userStream.next({
                action: "REGISTER_SUCCESS",
              })
            }
          })
      }

    constructor(private httpClient: HttpClient) {}
}