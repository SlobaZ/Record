import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateRecordTypeComponent } from './update-recordtype.component';

describe('UpdateRecordTypeComponent', () => {
  let component: UpdateRecordTypeComponent;
  let fixture: ComponentFixture<UpdateRecordTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateRecordTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateRecordTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
