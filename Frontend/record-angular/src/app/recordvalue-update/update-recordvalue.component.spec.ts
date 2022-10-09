import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateRecordValueComponent } from './update-recordvalue.component';

describe('UpdateRecordValueComponent', () => {
  let component: UpdateRecordValueComponent;
  let fixture: ComponentFixture<UpdateRecordValueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateRecordValueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateRecordValueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
