import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: any = {}
  cartCount = Object.keys(this.cart).length

  /*items: Book[] = [];

  addToCart(book: Book) {
    this.items.push(book);
  }

  getItems() {
    return this.items;
  }

  clearCart() {
    this.items = [];
    return this.items;
  }
*/
  constructor() { }
}
