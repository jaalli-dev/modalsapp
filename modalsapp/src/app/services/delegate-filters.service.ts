import { Injectable } from '@angular/core';
import { Observable, Observer, Subscriber } from 'rxjs';
import { share } from 'rxjs/operators';
import { FilterEnabled } from 'src/app/FilterEnabled';

@Injectable({
  providedIn: 'root'
})
export class DelegateFiltersService {
  private _enabledFilters: FilterEnabled[] = [];
  filterChange: Observable<FilterEnabled[]> = new Observable();
  private _observer: Observer<FilterEnabled[]> = new Subscriber();

  constructor() { 
    this.filterChange = new Observable((observer: Subscriber<FilterEnabled[]>) => 
      (this._observer = observer)).pipe(share());
  }

  changeFilters(enabledFilters: FilterEnabled[]) {
    this._enabledFilters = enabledFilters;
    this._observer.next(enabledFilters);
  }

  getEnabledFilters(): FilterEnabled[] {
    return this._enabledFilters;
  }
}