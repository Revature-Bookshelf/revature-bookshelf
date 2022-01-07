import { Component } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart-access',
  templateUrl: './cart-access.component.html',
  styleUrls: ['./cart-access.component.scss']
})
export class CartAccessComponent {

  count = 0;

  constructor(private cartService: CartService) { }

  ngDoCheck() {
    this.count = this.cartService.cartCount;
  }


}
