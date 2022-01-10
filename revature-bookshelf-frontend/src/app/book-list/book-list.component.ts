import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  books: Array<any> = []

  constructor(private booksService: BooksService, private router: Router) {
  }

  selectedValue = "all";


  getBooks() {
    if (this.selectedValue == "all") {
      this.booksService.getAllBooks().subscribe({
        next: (response: any) => {
          this.books = response
        }
      })
    } else if (this.selectedValue == "available") {
      this.booksService.getAvailableBooks().subscribe({
        next: (response: any) => {
          this.books = response
        }
      })
    }
  }

  ngOnInit(): void {
    this.getBooks();
  }

}

