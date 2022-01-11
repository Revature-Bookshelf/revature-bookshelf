import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  apiUrl = "http://localhost:8080/api/cart";

  constructor(private httpClient: HttpClient) { }

  cart: any = {}
  items: books[] = [];

  addToCart(bookId: number) {
    return this.httpClient.post(`${this.apiUrl}/add/{bookId}`);
  }

  deleteItems(bookId: number) {
    return this.httpClient.delete(`${this.apiUrl}/delete/{bookId}`);
  }

  clearCart() {
    this.items = [];
    return this.items;
  }
}
