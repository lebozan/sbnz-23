import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemRecommendComponent } from './item-recommend.component';

describe('ItemRecommendComponent', () => {
  let component: ItemRecommendComponent;
  let fixture: ComponentFixture<ItemRecommendComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ItemRecommendComponent]
    });
    fixture = TestBed.createComponent(ItemRecommendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
