import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateJobComponent } from './create-job/create-job.component';
import { JobsComponent } from './job/jobs.component';
import { ModifyJobsComponent } from './modify-jobs/modify-jobs.component';


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
  }
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
