import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { JobListComponent } from './job-list/job-list.component';
import { JobFormComponent } from './job-form/job-form.component';

const routes: Routes = [
  { path:'job-list', component:JobListComponent},
  { path: 'jobs', component: JobListComponent },
  { path: 'jobs/add', component: JobFormComponent },
  { path: 'jobs/edit/:id', component: JobFormComponent },
  { path: '', redirectTo: '/jobs', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
