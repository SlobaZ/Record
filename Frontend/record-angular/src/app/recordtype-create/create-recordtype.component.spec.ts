import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRecordTypeComponent } from './create-recordtype.component';

describe('CreateRecordTypeComponent', () => {
  let component: CreateRecordTypeComponent;
  let fixture: ComponentFixture<CreateRecordTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateRecordTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateRecordTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
