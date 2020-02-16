import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Merchant} from "../../../model/merchant";
import {MerchantService} from "../../../service/merchant.service";

@Component({
  selector: 'app-create-merchant',
  templateUrl: './create-merchant.component.html',
  styleUrls: ['./create-merchant.component.css']
})
export class CreateMerchantComponent implements OnInit {

  merchant: Merchant = new Merchant();
  submitted = false;

  constructor(private merchantService: MerchantService,
              private router: Router) { }

  ngOnInit() {
  }

  addMerchant(): void {
    this.submitted = false;
    this.merchant = new Merchant();
  }

  saveMerchant() {
    this.merchantService.createMerchant(this.merchant).subscribe(
      data => console.log(data),
      error => console.error(error))
    ;

    this.merchant = new Merchant();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.saveMerchant();
  }

  gotoList() {
    this.router.navigate(['/merchant-list']);
  }

}
