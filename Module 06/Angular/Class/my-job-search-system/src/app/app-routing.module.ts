import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { MyJobsComponent } from './pages/my-jobs/my-jobs.component';
import { JobListingComponent } from './pages/job-listing/job-listing.component';
import { JobsComponent } from './pages/jobs/jobs.component';
import { JobDetailsComponent } from './pages/job-details/job-details.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { LoginComponent } from './pages/login/login.component';
import { CreateNewJobComponent } from './pages/create-new-job/create-new-job.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';

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
