import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeerUserDetailsComponent } from './employeer-user-details.component';

describe('EmployeerUserDetailsComponent', () => {
  let component: EmployeerUserDetailsComponent;
  let fixture: ComponentFixture<EmployeerUserDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EmployeerUserDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployeerUserDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
