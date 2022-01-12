import { Pipe, PipeTransform } from '@angular/core';@Pipe({
  name:'search'
})export class SearchPipe implements PipeTransform {
  transform(searchInput: string): any[]{
    if(!searchInput) {
      return  [];
    }       searchInput = searchInput.toLowerCase();
    // @ts-ignore
    return searchInput.getSearchResults(
      x =>x.toLowerCase().includes(searchInput)
    )
  }
}
