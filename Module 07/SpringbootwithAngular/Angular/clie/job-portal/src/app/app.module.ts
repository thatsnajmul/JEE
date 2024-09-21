import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JobListComponent } from './job-list/job-list.component';
import { JobFormComponent } from './job-form/job-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { FooterComponent } from './footer/footer.component';
import { JobListViewComponent } from './job-list-view/job-list-view.component';
import { CompaniesComponent } from './companies/companies.component';
import { SearchComponent } from './search/search.component';
import { CalenderComponent } from './calender/calender.component';
import { GeoService } from './service/geo/geo.service';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { CurrentTimeComponent } from './current-time/current-time.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RegistrationComponent } from './registration/registration.component';
import { CreateJobApplicationComponent } from './create-job-application/create-job-application.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ViewAllCompaniesComponent } from './view-all-companies/view-all-companies.component';
import { AddJobComponent } from './admin/addjob/add-job.component';
;




@NgModule({
  declarations: [
    AppComponent,
    JobListComponent,
    JobFormComponent,
    NavBarComponent,
    FooterComponent,
    JobListViewComponent,
    CompaniesComponent,
    SearchComponent,
    CalenderComponent,
    CurrentTimeComponent,
    LoginComponent,
    LogoutComponent,
    RegistrationComponent,
    CreateJobApplicationComponent,
    HomeComponent,
    AdminComponent,
    UserProfileComponent,
    ViewAllCompaniesComponent,
    AddJobComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory })
    
    

  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch()),
    GeoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
