import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Merchant } from "../../../model/merchant";
import { MerchantService } from "../../../service/merchant.service";
import { Address } from "../../../model/address";
import { Phone } from "../../../model/phone";
import { Email } from "../../../model/email";

@Component({
  selector: 'app-create-merchant',
  templateUrl: './create-merchant.component.html',
  styleUrls: ['./create-merchant.component.css']
})
export class CreateMerchantComponent implements OnInit {

  merchant: Merchant = new Merchant();
  submitted = false;

  message: string;

  constructor(private merchantService: MerchantService,
              private router: Router
              ) { }

  ngOnInit() {
  }

  addMerchant(): void {
    this.submitted = false;
    this.merchant = new Merchant();
  }

  saveMerchant() {
    let address = new Address();
    address.cdCity = '11';
    address.cdNeighborhood = '11';
    address.cdUf = '11';
    address.cdZipcode = '111111';
    address.dsAddress = '1111';
    address.nuAddress = '11';
    address.dsComplement = '11';

    let phone = new Phone();
    phone.nuDdd = '11';
    phone.nuPhone = '111111111';
    phone.tpPhone = 'RESIDENCIAL';

    let email = new Email();
    email.dsEmail = 'italo@hot.com';

    this.merchant.emails.push(email);
    this.merchant.phones.push(phone);
    this.merchant.address = address;

    this.merchantService.createMerchant(this.merchant).subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.error(error);
        if(error.error.status === 400){
          console.log(error.error);
        }
      }
    );

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
