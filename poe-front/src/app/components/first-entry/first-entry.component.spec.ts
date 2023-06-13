import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstEntryComponent } from './first-entry.component';

describe('FirstEntryComponent', () => {
  let component: FirstEntryComponent;
  let fixture: ComponentFixture<FirstEntryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FirstEntryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FirstEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
