import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  searchResults: any;

  // @ts-ignore
  constructor(public searchResults: SearchResults) {
  }

  ngOnInit() {
    this.searchResults = this.searchResults.getSearchResults().subscribe({
      next: (response: any) => {
        this.searchResults = response
      }
    });
  }
}
