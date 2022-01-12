import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { AddressCardComponent } from './address-card/address-card.component';


@Injectable({
  providedIn: 'root'
})
export class AddressService {
  endpoint: string = 'http://localhost:9001';
  headers = new HttpHeaders().set('Content-Type', 'application/json');
  
  private addresses: Array<any> = [];

  addressStream: BehaviorSubject<any> = new BehaviorSubject({
    action: '',
    addresses: this.addresses  
  });

  getToken() {
    let token = localStorage.getItem("token") || null
    return token;
  }

  getAddress() {
    this.httpClient.get(`${this.endpoint}/api/address`)
      .subscribe({
        next: (reponse: any) => {
          console.log(reponse);
          this.addresses = reponse;
          this.addressStream.next({
            action: 'LOAD_ADDRESSES',
            addresses: this.addresses
          })
        }
      }) 
  }

  addAddress(formData: any) {
    this.httpClient.post(`${this.endpoint}/api/addresses`, formData)
      .subscribe({
        next: (response: any) => {
          console.log(response)
          this.addressStream.next({
            action: "ADDRESS_ADDED",
          })
        }
      })
  }

 


  constructor(private httpClient: HttpClient) { }
}
