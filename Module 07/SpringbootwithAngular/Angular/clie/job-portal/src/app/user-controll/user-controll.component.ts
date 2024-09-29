import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user/user.service';
import { User } from '../model/user.model';
import { ActivatedRoute, Router } from '@angular/router'; // Import Router and ActivatedRoute


@Component({
  selector: 'app-user-controll',
  templateUrl: './user-controll.component.html',
  styleUrl: './user-controll.component.css'
})
export class UserControllComponent implements OnInit{

  users: User[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.userService.getUsers().subscribe((data) => {
      this.users = data;
    });
  }

  deleteUser(id: number): void {
    if (confirm('Are you sure you want to delete this user?')) {
      this.userService.deleteUser(id).subscribe(() => {
        this.getUsers(); // Refresh the user list after deletion
      });
    }
  }

  editUser(user: User): void {
    this.router.navigate(['/edit-user', user.id]); // Assuming '/edit-user/:id' route is defined
  }
  



}
