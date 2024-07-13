import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatelocationComponent } from './createlocation/createlocation.component';
import { LocationComponent } from './location/location.component';
import { EmployeeComponent } from './employee/employee.component';
import { StudentviewComponent } from './student/studentview/studentview.component';
import { CreatestudentComponent } from './student/createstudent/createstudent.component';
import { UpdatestudentComponent } from './student/updatestudent/updatestudent.component';
import { LocationService } from './service/location.service';


@NgModule({
  declarations: [
    AppComponent,
    CreatelocationComponent,
   LocationService,
    LocationComponent,
    
    EmployeeComponent,
          StudentviewComponent,
          CreatestudentComponent,
          UpdatestudentComponent,   
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
