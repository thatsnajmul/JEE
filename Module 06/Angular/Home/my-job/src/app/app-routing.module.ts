import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateNewJobComponent } from './create-new-job/create-new-job.component';
import { HomeComponent } from './home/home.component';
import { JobDetailsComponent } from './job-details/job-details.component';
import { JobListingComponent } from './job-listing/job-listing.component';
import { JobsComponent } from './jobs/jobs.component';
import { LoginComponent } from './login/login.component';
import { MyJobsComponent } from './my-jobs/my-jobs.component';
import { RegistrationComponent } from './registration/registration.component';
import { AdminGuard } from './admin.guard';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'create-new-job', component: CreateNewJobComponent, canActivate: [AdminGuard] },
  { path: 'job-details/:id', component: JobDetailsComponent },
  { path: 'job-listing', component: JobListingComponent },
  { path: 'jobs', component: JobsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'my-jobs', component: MyJobsComponent },
  { path: 'registration', component: RegistrationComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

