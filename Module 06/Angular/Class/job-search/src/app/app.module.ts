import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateNewJobComponent } from './view/create-new-job/create-new-job.component';
import { HomeComponent } from './view/home/home.component';
import { JobDetailsComponent } from './view/job-details/job-details.component';
import { JobListingComponent } from './view/job-listing/job-listing.component';
import { JobsComponent } from './view/jobs/jobs.component';
import { LoginComponent } from './view/login/login.component';
import { MyJobsComponent } from './view/my-jobs/my-jobs.component';
import { RegistrationComponent } from './view/registration/registration.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateNewJobComponent,
    HomeComponent,
    JobDetailsComponent,
    JobListingComponent,
    JobsComponent,
    LoginComponent,
    MyJobsComponent,
    RegistrationComponent,
    AdminLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
