import { Component, OnInit } from '@angular/core';
import { PersonalDetailsService } from '../../service/personal-details/personal-details.service';
import { PersonalDetails } from '../../model/personal-details-model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-personal-details',
  templateUrl: './personal-details.component.html',
  styleUrl: './personal-details.component.css'
})
export class PersonalDetailsComponent implements OnInit{
  
    currentStep: number = 1;  // Initialize with the first step
    router: any;
  

    // Navigate to the next step
  nextStep() {
    if (this.currentStep < 10) { // Assume you have 10 steps
      this.currentStep++;
    }
  }

  // Navigate to the previous step
  previousStep() {
    if (this.currentStep > 1) {
      this.currentStep--;
    }
  }

  // Directly go to a specific step
  goToStep(step: number) {
    this.currentStep = step;
  }



  personalDetailsForm: FormGroup;
    
    personalDetailsId: number | null = null; // To hold the ID of the personal details being edited

    constructor(private fb: FormBuilder, private personalDetailsService: PersonalDetailsService) {
        this.personalDetailsForm = this.fb.group({
            firstName: ['', Validators.required],
            lastName: ['', Validators.required],
            gender: ['', Validators.required],
            birthday: ['', Validators.required],
            email: ['', [Validators.required, Validators.email]],
            phone: ['', Validators.required],
            address: ['', Validators.required],
            city: ['', Validators.required],
            country: ['', Validators.required],
            zipCode: ['', Validators.required],
            // Add other fields as needed
        });
    }

    ngOnInit() {
        this.loadPersonalDetails(); // Load initial details if needed
    }

    

    loadPersonalDetails() {
        // Logic to load personal details from service
        this.personalDetailsService.getPersonalDetails().subscribe(details => {
            // Populate the form if editing
            if (this.personalDetailsId) {
                this.personalDetailsForm.patchValue(details.find(d => d.id === this.personalDetailsId));
            }
        });
    }

  

    createOrUpdatePersonalDetails() {
        if (this.personalDetailsForm.valid) {
            if (this.personalDetailsId) {
                this.updatePersonalDetails(this.personalDetailsId);
                this.router.navigate(['/']);
            } else {
                // Create new personal details logic here (not shown)
            }
        }
    }

    updatePersonalDetails(id: number) {
        this.personalDetailsService.updatePersonalDetails(id, this.personalDetailsForm.value).subscribe(() => {
            this.loadPersonalDetails();
            this.personalDetailsId = null; // Reset ID after updating
            this.personalDetailsForm.reset(); // Reset the form if needed
        });
    }

    deletePersonalDetails(id: number) {
        this.personalDetailsService.deletePersonalDetails(id).subscribe(() => {
            this.loadPersonalDetails();
        });
    }

}
