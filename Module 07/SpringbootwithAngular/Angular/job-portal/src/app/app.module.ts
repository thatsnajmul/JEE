import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { SearchJobsComponent } from './search-jobs/search-jobs.component';

import { JobListingComponent } from './job-listing/job-listing.component';
import { FooterComponent } from './footer/footer.component';
import { CompaniesComponent } from './companies/companies.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AddJobComponent } from './add-job/add-job.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    SearchJobsComponent,
    JobListingComponent,
    FooterComponent,
    CompaniesComponent,
    AddJobComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
