import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { JobListComponent } from './job-list/job-list.component';
import { JobFormComponent } from './job-form/job-form.component';
import { JobListViewComponent } from './job-list-view/job-list-view.component';
import { CompaniesComponent } from './companies/companies.component';
import { SearchComponent } from './search/search.component';
import { CurrentTimeComponent } from './current-time/current-time.component';
import { CreateJobApplicationComponent } from './create-job-application/create-job-application.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { AdminComponent } from './admin/admin.component';
import { LogoutComponent } from './logout/logout.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ViewAllCompaniesComponent } from './view-all-companies/view-all-companies.component';
import { AddJobComponent } from './admin/addjob/add-job.component';
import { EmployeerComponent } from './employeer/employeer.component';
import { JobseekerComponent } from './jobseeker/jobseeker.component';
import { UserDetailsComponent } from './jobseeker/user-details/user-details.component';
import { AdminUserDetailsComponent } from './admin/admin-user-details/admin-user-details.component';
import { JobDetailsComponent } from './job-details/job-details.component';
import { ApplicationListComponent } from './application-list/application-list.component';
import { JobApplicationEditComponent } from './job-application-edit/job-application-edit.component';
import { AddPersonalDetailsComponent } from './jobseeker/add-personal-details/add-personal-details.component';


const routes: Routes = [

  //For Users
  
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full'
  },
  
  {path: '', redirectTo: '/home', pathMatch: 'full' },
  {path:'job-list-view', component: JobListViewComponent},
  {path: 'companies', component:CompaniesComponent},
  {path: 'view-all-companies', component:ViewAllCompaniesComponent},
  {path: 'search', component:SearchComponent},
  {path: 'current-time', component:CurrentTimeComponent},
  {path: 'create-job-application', component:CreateJobApplicationComponent},
  //Add

  {path:'login', component:LoginComponent},
  {path:'registration', component:RegistrationComponent},
  {path:'admin', component:AdminComponent},
  {path:'logout', component:LogoutComponent},
  {path:'user-profile', component:UserProfileComponent},
  {path:'add-job', component:AddJobComponent},
  {path:'job-details', component:JobDetailsComponent},
  //
  { path: 'job-applications', component: ApplicationListComponent }, //
  { path: 'job-applications/edit/:id', component: JobApplicationEditComponent },
  { path: 'admin/job-form', component: JobFormComponent},


  //
  {path:'employeer', component:EmployeerComponent},
  {path:'jobseeker', component:JobseekerComponent},
  {path:'user-details', component:UserDetailsComponent},
  {path:'admin-user-details', component:AdminUserDetailsComponent},
  {path:'add-personal-details', component:AddPersonalDetailsComponent},

  //For Admin
  { path:'job-list', component:JobListComponent},
  { path: 'jobs', component: JobListComponent },
  { path: 'jobs/add', component: JobFormComponent },
  { path: 'job-details/:id', component: JobDetailsComponent },
  { path: 'jobs/edit/:id', component: JobFormComponent },


  { path: 'register', component: RegistrationComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/register', pathMatch: 'full' }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
