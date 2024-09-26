import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HotelCreateComponent } from './hotel/hotel-create/hotel-create.component';
import { HotelViewComponent } from './hotel/hotel-view/hotel-view.component';
import { RoomCreateComponent } from './room/room-create/room-create.component';
import { RoomViewComponent } from './room/room-view/room-view.component';
import { HomeComponent } from './home/home/home.component';
import { HTTP_INTERCEPTORS, provideHttpClient, withFetch } from '@angular/common/http';
import { RoomByHotelComponent } from './hotel/room-by-hotel/room-by-hotel.component';
import { LocationCreateComponent } from './location/location-create/location-create.component';
import { LocationViewComponent } from './location/location-view/location-view.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TokenInterceptor } from './guards/TokenInterceptor';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './login/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    HotelCreateComponent,
    HotelViewComponent,
    RoomCreateComponent,
    RoomViewComponent,
    HomeComponent,
    RoomByHotelComponent,
    LocationCreateComponent,
    LocationViewComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(
      withFetch()
    ),
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
