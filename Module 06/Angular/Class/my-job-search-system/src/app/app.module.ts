import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { CreateNewJobComponent } from './pages/create-new-job/create-new-job.component';
import { HomeComponent } from './pages/home/home.component';
import { JobDetailsComponent } from './pages/job-details/job-details.component';
import { JobListingComponent } from './pages/job-listing/job-listing.component';
import { JobsComponent } from './pages/jobs/jobs.component';
import { MyJobsComponent } from './pages/my-jobs/my-jobs.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateNewJobComponent,
    HomeComponent,
    JobDetailsComponent,
    JobListingComponent,
    JobsComponent,
    MyJobsComponent,
    RegistrationComponent,
    AdminLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
