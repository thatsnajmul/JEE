import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonalDetailsService } from '../../service/personal-details/personal-details.service';

@Component({
  selector: 'app-add-personal-details',
  templateUrl: './add-personal-details.component.html',
  styleUrls: ['./add-personal-details.component.css'] // Corrected to styleUrls
})
export class AddPersonalDetailsComponent implements OnInit {

  addPersonalDetailsForm!: FormGroup;
  isEditMode = false;
  personalDetailsId: number = 0;

  constructor(
    private fb: FormBuilder,
    private personalDetailsService: PersonalDetailsService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Initialize the form with validation where necessary
    this.addPersonalDetailsForm = this.fb.group({
      // Step 1: Personal Details
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      gender: ['', Validators.required],
      birthday: ['', Validators.required],

      // Step 2: Contact Details
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required],
      website: [''],

      // Step 3: Address Details
      address: ['', Validators.required],
      city: ['', Validators.required],
      country: ['', Validators.required],
      zipCode: ['', Validators.required],

      // Step 4: Skills
      computerSkills: [''],
      languageSkills: [''],

      // Step 5: Educational Details
      instituteName1: [''],
      subjectName1: [''],
      passingYear1: [''],
      gpa1: [''],

      // Step 6: Work Experience
      companyName1: [''],
      designation1: [''],

      // Step 7: Certification
      certificationName: [''],
      certificationYear: [''],

      // Step 8: Awards
      awardName: [''],
      awardYear: [''],

      // Interest Intro
      interestIntro: ['']
    });

    // Check if this is an edit mode
    this.route.params.subscribe(params => {
      this.personalDetailsId = +params['id'];
      if (this.personalDetailsId) {
        this.isEditMode = true;
        this.loadPersonalDetails(this.personalDetailsId); // Load data if in edit mode
      }
    });
  }

  // Load existing personal details for edit mode
  loadPersonalDetails(id: number): void {
    this.personalDetailsService.getPersonalDetailById(id).subscribe(details => {
      if (details) {
        this.addPersonalDetailsForm.patchValue(details); // Populate the form with data
      }
    });
  }

  // Handle form submission (either create or update)
  onSubmit(): void {
    if (this.addPersonalDetailsForm.invalid) {
      console.log('Form is invalid, submission halted.');
      return;
    }

    if (this.isEditMode) {
      this.updatePersonalDetails(); // Update existing personal details
    } else {
      this.createOrUpdatePersonalDetails(); // Create new personal details
    }
  }

  // Create new personal details
  createOrUpdatePersonalDetails(): void {
    const personalDetails = this.addPersonalDetailsForm.value;
    this.personalDetailsService.createPersonalDetail(personalDetails).subscribe(() => {
      console.log('Personal details created successfully');
      this.router.navigate(['/']); // Navigate after creation
    }, error => {
      console.error('Error creating personal details:', error);
    });
  }

  // Update existing personal details
  updatePersonalDetails(): void {
    const personalDetails = this.addPersonalDetailsForm.value;
    this.personalDetailsService.updatePersonalDetail(this.personalDetailsId, personalDetails).subscribe(() => {
      console.log('Personal details updated successfully');
      this.router.navigate(['/']); // Navigate after update
    }, error => {
      console.error('Error updating personal details:', error);
    });
  }
}
