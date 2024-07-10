import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrl: './location.component.css'
})
export class LocationComponent implements OnInit {
  locations: any;

  constructor(
    private locationService: LocationService,
    private router: Router,
    private httpClient: HttpClient
  ) {

  }

  ngOnInit(): void {

    this.locations = this.locationService.getAllLocation();
  }

  deleteLocation(id: string) {
    this.locationService.deleteLocation(id)
      .subscribe({
        next: res => {
          this.locations = this.locationService.getAllLocation();
          this.router.navigate(['location']);
        },
        error: error => {
          console.log(error);

        }

      });

  }








}
