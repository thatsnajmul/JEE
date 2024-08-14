import { Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

// import { EmployerGuard } from './guards/employer.guard';
// import { JobSeekerGuard } from './guards/job-seeker.guard';
// import { EmployerComponent } from './components/employer/employer.component';
// import { JobSeekerComponent } from './components/job-seeker/job-seeker.component';
// import { LoginComponent } from './components/login/login.component';
// import { RegistrationComponent } from './components/registration/registration.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'job-search';
}





const routes: Routes = [
  // { path: '', redirectTo: '/login', pathMatch: 'full' },
  // { path: 'login', component: LoginComponent },
  // { path: 'registration', component: RegistrationComponent },
  {
    // path: 'employer',
    // component: EmployerComponent,
    // canActivate: [EmployerGuard]
  },
  {
    // path: 'job-seeker',
    // component: JobSeekerComponent,
    // canActivate: [JobSeekerGuard]
  },
  // Add other routes as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
