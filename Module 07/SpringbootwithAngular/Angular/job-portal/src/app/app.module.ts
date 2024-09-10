import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { SearchJobsComponent } from './search-jobs/search-jobs.component';

import { JobListingComponent } from './job-listing/job-listing.component';
import { FooterComponent } from './footer/footer.component';
import { CompaniesComponent } from './companies/companies.component';
import { HttpClient, HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';

import { ReactiveFormsModule } from '@angular/forms';
import { JobCreateComponent } from './job-create/job-create.component';
import { JobEditComponent } from './job-edit/job-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    SearchJobsComponent,
    JobListingComponent,
    FooterComponent,
    CompaniesComponent,
    JobCreateComponent,
    JobEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
