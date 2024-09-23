import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JobListComponent } from './job-list/job-list.component';
import { JobFormComponent } from './job-form/job-form.component';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
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
import { EmployeerComponent } from './employeer/employeer.component';
import { JobseekerComponent } from './jobseeker/jobseeker.component';
import { UserDetailsComponent } from './jobseeker/user-details/user-details.component';
import { AdminUserDetailsComponent } from './admin/admin-user-details/admin-user-details.component';
import { EmployeerUserDetailsComponent } from './employeer/employeer-user-details/employeer-user-details.component';
import { ApplicationListComponent } from './application-list/application-list.component';
import { UserListComponent } from './user-list/user-list.component';
import { JobDetailsComponent } from './job-details/job-details.component';
import { JobApplicationEditComponent } from './job-application-edit/job-application-edit.component';
import { PersonalDetailsComponent } from './jobseeker/personal-details/personal-details.component';
import { NavLeftComponent } from './nav-left/nav-left.component';
import { SidebarLeftComponent } from './sidebar-left/sidebar-left.component';
import { SidebarRightComponent } from './sidebar-right/sidebar-right.component';
import { AddPersonalDetailsComponent } from './jobseeker/add-personal-details/add-personal-details.component';




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
    AddJobComponent,
    EmployeerComponent,
    JobseekerComponent,
    UserDetailsComponent,
    AdminUserDetailsComponent,
    EmployeerUserDetailsComponent,
    ApplicationListComponent,
    UserListComponent,
    JobDetailsComponent,
    JobApplicationEditComponent,
    PersonalDetailsComponent,
    NavLeftComponent,
    SidebarLeftComponent,
    SidebarRightComponent,
    AddPersonalDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory }),
    FormsModule,
    
    

  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch()),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
