import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobPostingEditComponent } from './job-posting-edit.component';

describe('JobPostingEditComponent', () => {
  let component: JobPostingEditComponent;
  let fixture: ComponentFixture<JobPostingEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [JobPostingEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JobPostingEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
