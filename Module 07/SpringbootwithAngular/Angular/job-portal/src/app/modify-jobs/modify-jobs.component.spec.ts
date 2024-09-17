import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyJobsComponent } from './modify-jobs.component';

describe('ModifyJobsComponent', () => {
  let component: ModifyJobsComponent;
  let fixture: ComponentFixture<ModifyJobsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ModifyJobsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifyJobsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
