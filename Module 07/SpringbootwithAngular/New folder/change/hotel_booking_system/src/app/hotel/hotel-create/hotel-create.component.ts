import { Component, OnInit } from '@angular/core';
import { Hotel } from '../../model/hotel.model';
import { HotelService } from '../../service/hotel.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LocationService } from '../../service/location.service';
import { Location } from '../../model/location.model';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-hotel-create',
  templateUrl: './hotel-create.component.html',
  styleUrls: ['./hotel-create.component.css'] // Updated to 'styleUrls'
})
export class HotelCreateComponent implements OnInit {

  image: File | null = null;
  hotel: Hotel = new Hotel();
  locations: Location[] = [];
  formGroup!: FormGroup;
  isAuthorized: boolean = false; // To check authorization

  constructor(
    private hotelService: HotelService,
    private formBuilder: FormBuilder,
    private router: Router,
    private locationService: LocationService,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    this.loadLocations();

    // Check if the user is authorized (has either ADMIN or HOTEL role)
    this.isAuthorized = this.authService.hasRole(['ADMIN', 'HOTEL']);

    if (!this.isAuthorized) {
      alert('You are not authorized to add hotels.');
      this.router.navigate(['/']); // Redirect to another page if not authorized
      return;
    }

    // Initialize the form with validators
    this.formGroup = this.formBuilder.group({
      name: ['', Validators.required],
      address: ['', Validators.required],
      maxPrice: ['', [Validators.required, Validators.min(0)]],
      minPrice: ['', [Validators.required, Validators.min(0)]],
      rating: ['', [Validators.required, Validators.min(0), Validators.max(5)]],
      location: [null, Validators.required]
    });
  }

  // Handle file input for image selection
  onFileSelected(event: any) {
    this.image = event.target.files[0];
  }

  // Load locations from the service
  loadLocations() {
    this.locationService.getAllLocations().subscribe({
      next: res => {
        this.locations = res;
      },
      error: err => {
        console.error('Error fetching locations:', err);
      }
    });
  }

  // Submit the hotel form with the selected image
  onSubmit() {
    if (this.formGroup.invalid) {
      alert('Please fill in all required fields with valid data.');
      return;
    }

    if (this.image) {
      const hotel: Hotel = {
        ...this.formGroup.value,
        location: { id: this.formGroup.value.location } as Location
      };

      this.hotelService.createHotel(hotel, this.image).subscribe({
        next: res => {
          console.log('Hotel added successfully', res);
          this.router.navigate(['/hotel']);  // Navigate to the hotel list or details page
        },
        error: err => {
          // this.router.navigate(['/hotel']); 
          console.error('Error adding hotel:', err);
        }
      });
    } else {
      alert('Please select an image.');
    }
  }

}
