import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonalDetailsService } from '../../service/personal-details/personal-details.service';

@Component({
  selector: 'app-personal-details',
  templateUrl: './personal-details.component.html',
  styleUrl: './personal-details.component.css'
})
export class PersonalDetailsComponent implements OnInit {

  personalDetails: any;
  personalDetailsId: number = 0;

  constructor(
    private personalDetailsService: PersonalDetailsService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Check if in view mode and get the personal details
    this.route.params.subscribe(params => {
      this.personalDetailsId = +params['id'];
      if (this.personalDetailsId) {
        this.loadPersonalDetails(this.personalDetailsId);
      }
    });
  }

  // Load personal details by ID
  loadPersonalDetails(id: number): void {
    this.personalDetailsService.getPersonalDetailById(id).subscribe(details => {
      if (details) {
        this.personalDetails = details; // Assign the data for display
      }
    });
  }

  // Navigate to edit component for editing the personal details
  goToEdit(): void {
    this.router.navigate(['/edit-personal-details', this.personalDetailsId]);
  }
}
