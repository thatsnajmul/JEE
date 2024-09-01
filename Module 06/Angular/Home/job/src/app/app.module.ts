import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateJobComponent } from './create-job/create-job.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { JobsComponent } from './job/jobs.component';
import {NgxPrintModule} from 'ngx-print';

import { ModifyJobsComponent } from './modify-jobs/modify-jobs.component';
import { UpdateModifyJobsComponent } from './update-modify-jobs/update-modify-jobs.component';
import { CreateJobApplicationComponent } from './create-job-application/create-job-application.component';
import { ViewJobApplicationComponent } from './view-job-application/view-job-application.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LogoutComponent } from './logout/logout.component';
import { CompaniesComponent } from './companies/companies.component';
import { AddJobComponent } from './admin/addjob/add-job.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { PersonaldetailComponent } from './personaldetail/personaldetail.component';







@NgModule({
  declarations: [
    AppComponent,
    CreateJobComponent,
    JobsComponent,
    ModifyJobsComponent,
    UpdateModifyJobsComponent,
    CreateJobApplicationComponent,
    ViewJobApplicationComponent,
    HomeComponent,
    AdminComponent,
    NavbarComponent,
    LogoutComponent,
    CompaniesComponent,
    AddJobComponent,
    LoginComponent,
    RegistrationComponent,
    UserprofileComponent,
    PersonaldetailComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,  // Add FormsModule here
    ReactiveFormsModule,
    HttpClientModule,
    NgxPrintModule
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
