import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { ItemsComponent } from './components/items/items.component';
import { FiltersComponent } from './components/filters/filters.component';
import { ItemComponent } from './components/item/item.component';
import { FilterComponent } from './components/filter/filter.component';
import { AddItemModalComponent } from './components/add-item-modal/add-item-modal.component';
import { AddFilterModalComponent } from './components/add-filter-modal/add-filter-modal.component';
import { DateDropdownComponent } from './components/date-dropdown/date-dropdown.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ItemsComponent,
    FiltersComponent,
    ItemComponent,
    FilterComponent,
    AddItemModalComponent,
    AddFilterModalComponent,
    DateDropdownComponent
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [AddFilterModalComponent]
})
export class AppModule { }
