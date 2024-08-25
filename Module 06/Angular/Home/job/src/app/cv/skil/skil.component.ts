import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  skills: string[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('assets/cv-data.json').subscribe(data => {
      this.skills = data.skills;
    });
  }
}

