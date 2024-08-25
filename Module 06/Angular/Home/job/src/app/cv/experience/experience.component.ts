import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {
  experience: any[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('assets/cv-data.json').subscribe(data => {
      this.experience = data.experience;
    });
  }
}

