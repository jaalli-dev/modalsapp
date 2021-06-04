import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../Item';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private apiUrl = 'http://localhost:8080/api/items';

  constructor(private http: HttpClient) { }

  getItems(): Observable<Item[]> {
    return this.http.get<Item[]>(this.apiUrl);
  }

  getItemsByFilter(id: number): Observable<Item[]> {
    if (id === 0) {
      return this.http.get<Item[]>(this.apiUrl);
    }
    return this.http.get<Item[]>(this.apiUrl + `-by-filter/${id}`);
  }

  addItem(item: Item) {
    return this.http.post<Item>(this.apiUrl, item, httpOptions);
  }

  updateItem(item: Item) {
    return this.http.put<Item>(this.apiUrl, item, httpOptions);
  }

  deleteItem(item: Item): Observable<Item> {
    return this.http.delete<Item>(this.apiUrl + `/delete/${item.id}`);
  }

}
