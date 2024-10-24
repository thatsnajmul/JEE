import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobPostingDetailComponent } from './job-posting-detail.component';

describe('JobPostingDetailComponent', () => {
  let component: JobPostingDetailComponent;
  let fixture: ComponentFixture<JobPostingDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [JobPostingDetailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JobPostingDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
