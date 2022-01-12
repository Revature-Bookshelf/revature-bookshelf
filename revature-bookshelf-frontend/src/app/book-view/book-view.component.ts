import { Component, Input, OnInit } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-book-view',
  templateUrl: './book-view.component.html',
  styleUrls: ['./book-view.component.scss']
})
export class BookViewComponent implements OnInit {

  @Input("value") book: any = {}
  constructor(private cartService: CartService) { }

  addToCart(bookId) {
    this.cartService.addToCart(bookId);
  }

  ngOnInit(): void {
  }

}
