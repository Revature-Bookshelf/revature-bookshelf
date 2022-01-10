import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-book-view',
  templateUrl: './book-view.component.html',
  styleUrls: ['./book-view.component.scss']
})
export class BookViewComponent implements OnInit {

  @Input("value")book:any={}
  constructor() { }

  ngOnInit(): void {
  }

}
