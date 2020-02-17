import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMerchantComponent } from './list-merchant.component';

describe('ListMerchantComponent', () => {
  let component: ListMerchantComponent;
  let fixture: ComponentFixture<ListMerchantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListMerchantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMerchantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
