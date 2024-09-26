import { Component, OnInit } from '@angular/core';
import { HotelService } from '../../service/hotel.service';
import { LocationService } from '../../service/location.service';
import { Router } from '@angular/router';
import { RoomService } from '../../service/room.service';

@Component({
  selector: 'app-hotel-view',
  templateUrl: './hotel-view.component.html',
  styleUrl: './hotel-view.component.css'
})
export class HotelViewComponent implements OnInit {

  locations: any;
  hotels: any;
  rooms:any;

  constructor(
    private hotelService: HotelService,
    private locationService: LocationService,
    private roomService: RoomService,
    private router: Router

  ) { }

  ngOnInit(): void {

    this.loadLocations();
  }


  loadLocations() {

    this.locations = this.locationService.getAllLocations();
    this.hotelService.getAllHotel().subscribe({

      next: res => {
        this.hotels = res;
      },

      error: err => {
        console.log(err)

      }

    });


  }

  // getRoomByHotel(id:string){
    
  //     this.roomService.getRoomByHotel(id).subscribe({

  //       next: res => {
  //         this.rooms = res;
  //         console.log(this.rooms);
  //       },
  
  //       error: err => {
  //         console.log(err)
  
  //       }
  
  //     });

  // }


  viewRooms(hotelId: string): void {
    // Navigate to the RoomListComponent with the hotel ID
    this.router.navigate(['/room', hotelId]);
  }




}
