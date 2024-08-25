import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-personal-info',
  templateUrl: './personal-info.component.html',
  styleUrls: ['./personal-info.component.css']
})
export class PersonalInfoComponent implements OnInit {
  personalInfo: any = {};

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('assets/cv-data.json').subscribe(data => {
      this.personalInfo = data.personalInfo;
    });
  }
}

