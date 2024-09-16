import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { JobPostingListComponent } from './job-posting-list/job-posting-list.component';
import { JobPostingDetailComponent } from './job-posting-detail/job-posting-detail.component';
import { JobPostingEditComponent } from './job-posting-edit/job-posting-edit.component';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort'; // If using sorting
import { MatPaginatorModule } from '@angular/material/paginator'; // If using pagination
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    JobPostingListComponent,
    JobPostingDetailComponent,
    JobPostingEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    MatSortModule,      // If using sorting
    MatPaginatorModule,
    HttpClientModule 
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
