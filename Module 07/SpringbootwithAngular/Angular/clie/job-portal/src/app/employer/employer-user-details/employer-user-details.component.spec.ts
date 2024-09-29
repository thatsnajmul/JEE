import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployerUserDetailsComponent } from './employer-user-details.component';

describe('EmployerUserDetailsComponent', () => {
  let component: EmployerUserDetailsComponent;
  let fixture: ComponentFixture<EmployerUserDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EmployerUserDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployerUserDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
