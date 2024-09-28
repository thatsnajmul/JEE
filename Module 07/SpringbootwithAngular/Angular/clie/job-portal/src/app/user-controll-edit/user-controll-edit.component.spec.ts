import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserControllEditComponent } from './user-controll-edit.component';

describe('UserControllEditComponent', () => {
  let component: UserControllEditComponent;
  let fixture: ComponentFixture<UserControllEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserControllEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserControllEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
