import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { HomeComponent } from './view/home/home.component';
import { CreateNewJobComponent } from './view/create-new-job/create-new-job.component';
import { JobDetailsComponent } from './view/job-details/job-details.component';
import { JobListingComponent } from './view/job-listing/job-listing.component';
import { JobsComponent } from './view/jobs/jobs.component';
import { LoginComponent } from './view/login/login.component';
import { MyJobsComponent } from './view/my-jobs/my-jobs.component';
import { RegistrationComponent } from './view/registration/registration.component';

const routes: Routes = [
  {
    path: '',
    redirectTo:'home',
    pathMatch: 'full'
  },
  {
    path:'admin-login',
    component: AdminLoginComponent
  },
  {
    path:'home',
    component: HomeComponent
  },
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'registration',
    component: RegistrationComponent
  },
  {
    path:'jobs',
    component: JobsComponent
  },
  {
    path:'job-details',
    component: JobDetailsComponent
  },
  {
    path:'new-jobs',
    component: JobsComponent
  },
  {
    path:'job-listing',
    component: JobListingComponent
  },
  {
    path:'my-jobs',
    component: MyJobsComponent
  },
  {
    path:'create-new-job',
    component:CreateNewJobComponent
  },
  {
    path:'**',
    component:HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
