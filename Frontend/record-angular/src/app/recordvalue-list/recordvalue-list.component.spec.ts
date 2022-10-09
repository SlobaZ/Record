import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecordValueListComponent } from './recordvalue-list.component';

describe('RecordValueListComponent', () => {
  let component: RecordValueListComponent;
  let fixture: ComponentFixture<RecordValueListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecordValueListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecordValueListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
