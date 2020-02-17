import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsMerchantComponent } from './details-merchant.component';

describe('DetailsMerchantComponent', () => {
  let component: DetailsMerchantComponent;
  let fixture: ComponentFixture<DetailsMerchantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsMerchantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsMerchantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
