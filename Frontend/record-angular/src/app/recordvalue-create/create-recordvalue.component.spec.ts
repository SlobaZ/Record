import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRecordValueComponent } from './create-recordvalue.component';

describe('CreateRecordValueComponent', () => {
  let component: CreateRecordValueComponent;
  let fixture: ComponentFixture<CreateRecordValueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateRecordValueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateRecordValueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
