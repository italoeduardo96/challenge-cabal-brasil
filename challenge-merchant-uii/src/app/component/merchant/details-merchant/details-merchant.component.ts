import { Component, OnInit, Input} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {Merchant} from "../../../model/merchant";
import {MerchantService} from "../../../service/merchant.service";
import {PhoneService} from "../../../service/phone.service";
import {Observable} from "rxjs";
import {Phone} from "../../../model/phone";
import {Email} from "../../../model/email";
import {Address} from "../../../model/address";
import {EmailService} from "../../../service/email.service";
import {AddressService} from "../../../service/address.service";

@Component({
  selector: 'app-details-merchant',
  templateUrl: './details-merchant.component.html',
  styleUrls: ['./details-merchant.component.css']
})
export class DetailsMerchantComponent implements OnInit {

  id: number;
  merchant: Merchant;
  phones: Observable<Phone[]>;
  emails: Observable<Email[]>;
  address: Address;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private merchantService: MerchantService,
              private phoneService: PhoneService,
              private emailService: EmailService,
              private addressService: AddressService  ) { }

  ngOnInit() {
    this.address = new Address();

    this.merchant = new Merchant();
    this.id = this.route.snapshot.params['id'];

    this.merchantService.getMerchantById(this.id).subscribe(
      data => {
        console.log(data);
        this.merchant = data as Merchant;
        this.getPhones();
        this.getAddress();
        this.getEmails();
      },
      error => console.error(error)
    );

  }

  goToList(){
    this.router.navigate(['/merchant-list']);
  }

  getPhones(){
    this.phones = this.phoneService.getPhonesMerchant(this.id);
  }

  getEmails(){
    this.emails = this.emailService.getEmailsMerchant(this.id);
  }

  getAddress(){
    this.addressService.getAddressMerchant(this.id).subscribe(
      data => {
        console.log(data);
        this.address = data as Address;
      },
      error => console.error(error)
    );
  }

}
