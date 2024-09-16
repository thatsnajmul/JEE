import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import path from 'path';
import { JobPostComponent } from './job-posting/job-post.component';

const routes: Routes = [
  {
    path:'job-post',
    component:JobPostComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
