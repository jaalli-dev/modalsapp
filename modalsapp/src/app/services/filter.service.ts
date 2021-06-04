import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Filter } from '../Filter';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class FilterService {
  private apiUrl = 'http://localhost:8080/api/filters';

  constructor(private http: HttpClient) { }

  getFilters(): Observable<Filter[]> {
    return this.http.get<Filter[]>(this.apiUrl);
  }

  addFilter(filter: Filter) {
    return this.http.post<Filter>(this.apiUrl, filter, httpOptions);
  }

  updateFilter(filter: Filter) {
    return this.http.put<Filter>(this.apiUrl, filter, httpOptions);
  }

  deleteFilter(filter: Filter): Observable<Filter> {
    return this.http.delete<Filter>(this.apiUrl + `/delete/${filter.id}`);
  }
}
