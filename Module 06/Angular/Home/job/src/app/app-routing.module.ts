import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateJobComponent } from './create-job/create-job.component';
import { JobsComponent } from './job/jobs.component';
import { ModifyJobsComponent } from './modify-jobs/modify-jobs.component';
import { UpdateModifyJobsComponent } from './update-modify-jobs/update-modify-jobs.component';
import { CreateJobApplicationComponent } from './create-job-application/create-job-application.component';
import { ViewJobApplicationComponent } from './view-job-application/view-job-application.component';

import { AdminComponent } from './admin/admin.component';
import {CompaniesComponent} from "./companies/companies.component";
import {HomeComponent} from "./home/home.component";
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGuard } from './guard/auth.guard';
import { RoleGuard } from './guard/role.guard';
import { PersonaldetailComponent } from './personaldetail/personaldetail.component';



const routes: Routes = [

  {
    path:'create-job',
    component: CreateJobComponent,
    canActivate:[AuthGuard, RoleGuard],
    data: { role: 'employer,admin'  }
    
    
  },
  {
    path:'jobs',
    component: JobsComponent
  },
  {
    path:'modify-jobs',
    component: ModifyJobsComponent,
    canActivate:[AuthGuard, RoleGuard],
    data: { role: 'employer,admin'  }
  },
  {
    path:'update-modify-jobs/:id',
    component: UpdateModifyJobsComponent,
    canActivate:[AuthGuard, RoleGuard],
    data: { role: 'employer,admin'  }
  },
  {
    path:'create-job-application',
    component: CreateJobApplicationComponent,
    canActivate:[AuthGuard, RoleGuard],
    data: { role: 'jobSeeker'  }
  },
  {
    path:'view-job-application',
    component: ViewJobApplicationComponent,
    canActivate:[AuthGuard, RoleGuard],
    data: { role: 'employer,admin'  }
  },
  {
    path:'admin',
    component: AdminComponent,
    canActivate:[AuthGuard, RoleGuard],
    data: { role: 'admin' }
  },
  {
    path:'companies',
    component: CompaniesComponent

  },
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'registration',
    component: RegistrationComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'userprofile',
    component: UserprofileComponent,
    canActivate:[AuthGuard, RoleGuard],
    data: { role: 'employer,admin,jobSeeker'  }
  },
  {
    path: 'logout',
    component: LogoutComponent
  },
  {
    path: 'personaldetail',
    component: PersonaldetailComponent,
    canActivate:[AuthGuard, RoleGuard],
    data: { role: 'jobSeeker' }

  }
  



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
