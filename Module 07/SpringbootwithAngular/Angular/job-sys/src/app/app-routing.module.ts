import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { JobPostingListComponent } from './job-posting-list/job-posting-list.component';
import { JobPostingDetailComponent } from './job-posting-detail/job-posting-detail.component';
import { JobPostingEditComponent } from './job-posting-edit/job-posting-edit.component';

const routes: Routes = [

  { path: '', component: JobPostingListComponent },
  { path: 'job-postings', component: JobPostingListComponent },
  { path: 'job-postings/:id', component: JobPostingDetailComponent },
  { path: 'job-postings/edit/:id', component: JobPostingEditComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
