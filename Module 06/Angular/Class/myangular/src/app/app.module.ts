import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatelocationComponent } from './createlocation/createlocation.component';
import { StudentComponent } from './student/student.component';
import { LocationComponent } from './location/location.component';
import { EmployeeComponent } from './employee/employee.component';


@NgModule({
  declarations: [
    AppComponent,
    CreatelocationComponent,
    StudentComponent,
    LocationComponent,
    
    EmployeeComponent,   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
