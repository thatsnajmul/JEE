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
import { AdminComponent } from './admin/admin.component';
import { LogoutComponent } from './logout/logout.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ViewAllCompaniesComponent } from './view-all-companies/view-all-companies.component';
import { JobseekerComponent } from './jobseeker/jobseeker.component';
import { UserDetailsComponent } from './jobseeker/user-details/user-details.component';
import { AdminUserDetailsComponent } from './admin/admin-user-details/admin-user-details.component';
import { JobDetailsComponent } from './job-details/job-details.component';
import { ApplicationListComponent } from './application-list/application-list.component';
import { JobApplicationEditComponent } from './job-application-edit/job-application-edit.component';
import { AddPersonalDetailsComponent } from './jobseeker/add-personal-details/add-personal-details.component';
import { PersonalDetailsComponent } from './jobseeker/personal-details/personal-details.component';
import { RegisterComponent } from './register/register.component';
import { AdminGuard } from './guards/admin.guard';
import { JobSeekerGuard } from './guards/job-seeker.guard';
import { EmployerGuard } from './guards/employer.guard';
import { EmployerComponent } from './employer/employer.component';
import { NotAuthorizedComponent } from './not-authorized/not-authorized.component';
// import { RoleGuard } from './guards/role.guard';
import { Role } from './model/role.model';
import { RoleGuard } from './guards/role.guard';


const routes: Routes = [

  
    {
      path: 'admin',
      component: AdminComponent,
      canActivate: [RoleGuard],
      data: { roles: [Role.ADMIN] }  // Only Admins can access this route
    },
    {
      path: 'jobseeker',
      component: JobseekerComponent,
      canActivate: [RoleGuard],
      data: { roles: [Role.JOB_SEEKER] }  // Only Job Seekers can access this route
    },
    {
      path: 'employer',
      component: EmployerComponent,
      canActivate: [RoleGuard],
      data: { roles: [Role.EMPLOYER] }  // Only Employers can access this route
    },
    {
      path: 'not-authorized',
      component: NotAuthorizedComponent,
      canActivate: [RoleGuard],
      data: { roles: [Role.ADMIN,Role.EMPLOYER,Role.JOB_SEEKER] }  // Redirect unauthorized users here
    },

  

  //For Users
  
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full'
  },
  
  {path: '', redirectTo: '/home', pathMatch: 'full' },
  {path:'job-list-view', component: JobListViewComponent},
  {path:'companies', component:CompaniesComponent},
  {path:'view-all-companies', component:ViewAllCompaniesComponent},
  {path:'search', component:SearchComponent},
  {path:'current-time', component:CurrentTimeComponent},
  {path:'create-job-application', component:CreateJobApplicationComponent},

  //Guardless
  {path:'jobs', component: JobListComponent },
  {path:'job-details', component:JobDetailsComponent},

  //AllGuard
  {path:'user-profile', component:UserProfileComponent, canActivate: [RoleGuard],
    data: { roles: [Role.ADMIN,Role.EMPLOYER,Role.JOB_SEEKER] } },
  
  // {path:'user-profile', component:UserProfileComponent, 
  //   canActivate:[AdminGuard,JobSeekerGuard,EmployerGuard]},
  
  //All AdminGuard
  //{path:'admin', component:AdminComponent, canActivate: [AdminGuard]},
  {
    path: 'not-authorized',
    component: NotAuthorizedComponent  // Redirect unauthorized access here
  },
  // {
  //   path: 'admin',
  //   component: AdminComponent,
  //   canActivate: [AdminGuard],
  //   data: { roles: ['ADMIN'] }  // Only Admin role can access this
  // },
  {path:'admin-user-details', component:AdminUserDetailsComponent},
  {path:'admin/job-form', component: JobFormComponent},
  {path:'job-applications', component: ApplicationListComponent }, //
  //{path:'job-applications/edit/:id', component: JobApplicationEditComponent },
  {path:'jobs/add', component: JobFormComponent },
  //{path:'job-details/:id', component: JobDetailsComponent },
  //{path:'jobs/edit/:id', component: JobFormComponent },
  {path:'job-list', component:JobListComponent},
  
  //All EmployerGuard
  //{path:'employer', component:EmployerComponent, canActivate: [EmployerGuard]},
  // {
  //   path: 'employer',
  //   component: EmployerComponent,
  //   canActivate: [EmployerGuard],
  //   data: { roles: ['EMPLOYER'] }  // Only Employer role can access this
  // },
  {path:'admin/job-form', component: JobFormComponent},
  {path:'job-applications', component: ApplicationListComponent }, //
  {path:'job-applications/edit/:id', component: JobApplicationEditComponent },
  {path:'jobs/add', component: JobFormComponent },
  {path:'job-details/:id', component: JobDetailsComponent },
  {path:'jobs/edit/:id', component: JobFormComponent },
  {path:'job-list', component:JobListComponent},

  //All JobSeekerGuard
  //{path:'jobseeker', component:JobseekerComponent,  canActivate: [JobSeekerGuard]},
  // {
  //   path: 'jobseeker',
  //   component: JobseekerComponent,
  //   canActivate: [JobSeekerGuard],
  //   data: { roles: ['JOB_SEEKER'] }  // Only JobSeeker role can access this
  // },
  
  {path:'user-details', component:UserDetailsComponent},
  {path:'add-personal-details', component:AddPersonalDetailsComponent},
  {path:'personal-details/:id', component: PersonalDetailsComponent },

  //Login And Registration
  {path:'login', component:LoginComponent},
  {path:'logout', component:LogoutComponent},
  {path:'register', component: RegisterComponent },
  //{path:'', redirectTo: '/register', pathMatch: 'full' },
  
  
  
  //{ path: 'edit-personal-details/:id', component: EditPersonalDetailsComponent },
  




  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
