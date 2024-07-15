import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { JobsComponent } from './pages/jobs/jobs.component';
import { CreateNewJobComponent } from './pages/create-new-job/create-new-job.component';
import { JobListingComponent } from './pages/job-listing/job-listing.component';
import { MyJobsComponent } from './pages/my-jobs/my-jobs.component';

const routes: Routes = [
  //Default route
  {
    path:'',
    redirectTo:'home',
    pathMatch:'full'
  },
  {
    path: 'home',
    component:HomeComponent
  },
  {
    path: 'login',
    component:LoginComponent
  },
  {
    path:'register',
    component: RegistrationComponent
  },
  {
    path:'jobs',
    component:JobsComponent
  },
  {
    path: 'new-job',
    component:CreateNewJobComponent
  },
  {
    path:'job-listing',
    component:JobListingComponent
  },
  {
    path:'my-jobs',
    component:MyJobsComponent
  },
  //While cart route
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
