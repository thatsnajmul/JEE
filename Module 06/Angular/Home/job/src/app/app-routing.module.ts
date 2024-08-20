import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateJobComponent } from './create-job/create-job.component';
import { JobsComponent } from './job/jobs.component';
import { ModifyJobsComponent } from './modify-jobs/modify-jobs.component';
import { UpdateModifyJobsComponent } from './update-modify-jobs/update-modify-jobs.component';
import { CreateJobApplicationComponent } from './create-job-application/create-job-application.component';
import { ViewJobApplicationComponent } from './view-job-application/view-job-application.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';


const routes: Routes = [

  {
    path:'create-job',
    component: CreateJobComponent
  },
  {
    path:'jobs',
    component: JobsComponent
  },
  {
    path:'modify-jobs',
    component: ModifyJobsComponent
  },
  {
    path:'update-modify-jobs/:id',
    component: UpdateModifyJobsComponent
  },
  {
    path:'create-job-application',
    component: CreateJobApplicationComponent
  },
  {
    path:'view-job-application',
    component: ViewJobApplicationComponent
  },
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'register',
    component: RegisterComponent
  },
  {
    path:'admin',
    component: AdminComponent
  }

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
