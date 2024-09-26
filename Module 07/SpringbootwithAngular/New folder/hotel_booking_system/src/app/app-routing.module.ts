import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HotelCreateComponent } from './hotel/hotel-create/hotel-create.component';
import { HotelViewComponent } from './hotel/hotel-view/hotel-view.component';
import { RoomByHotelComponent } from './hotel/room-by-hotel/room-by-hotel.component';
import { RegisterComponent } from './login/register/register.component';
import { LoginComponent } from './login/login/login.component';
import { AdminHotelGuard } from './guards/admin-hotel.guard';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [

  {path: 'hotel', component:HotelViewComponent},
  {path: 'room/:hotelId', component:RoomByHotelComponent},
  {path: 'hotel-create', component:HotelCreateComponent,  canActivate: [AdminHotelGuard]},
  {path: 'register', component:RegisterComponent},
  {path: 'login', component:LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
