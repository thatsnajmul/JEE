import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {
  education: any[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('assets/cv-data.json').subscribe(data => {
      this.education = data.education;
    });
  }
}

