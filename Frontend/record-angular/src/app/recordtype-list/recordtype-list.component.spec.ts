import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecordTypeListComponent } from './recordtype-list.component';

describe('RecordTypeListComponent', () => {
  let component: RecordTypeListComponent;
  let fixture: ComponentFixture<RecordTypeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecordTypeListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecordTypeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
