import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user/user.service';
import { User } from '../model/user.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-user-controll-edit',
  templateUrl: './user-controll-edit.component.html',
  styleUrl: './user-controll-edit.component.css'
})
export class UserControllEditComponent implements OnInit{

  userForm: FormGroup;
  userId!: number;
  user!: User;

  // Inject Router here
  constructor(
    private route: ActivatedRoute,
    private router: Router, // Add this line to inject the Router
    private userService: UserService,
    private fb: FormBuilder
  ) {
    this.userForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      role: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.userId = +this.route.snapshot.paramMap.get('id')!;
    this.getUserDetails(this.userId);
  }

  getUserDetails(id: number): void {
    this.userService.getUsers().subscribe((users) => {
      this.user = users.find((user) => user.id === id)!;
      if (this.user) {
        this.userForm.patchValue({
          name: this.user.name,
          email: this.user.email,
          role: this.user.role,
        });
      }
    });
  }

  editUser(): void {
    if (this.userForm.valid) {
      const updatedUser: User = {
        ...this.user,
        ...this.userForm.value,
      };
      this.userService.editUser(this.userId, updatedUser).subscribe(() => {
        alert('User updated successfully!');
        this.router.navigate(['/users']); // Navigate to the user list after saving
      });
    }
  }

}
