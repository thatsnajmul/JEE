import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateModifyJobsComponent } from './update-modify-jobs.component';

describe('UpdateModifyJobsComponent', () => {
  let component: UpdateModifyJobsComponent;
  let fixture: ComponentFixture<UpdateModifyJobsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateModifyJobsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateModifyJobsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
