import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {MerchantService} from "../../../service/merchant.service";
import {Merchant} from "../../../model/merchant";

@Component({
  selector: 'app-update-merchant',
  templateUrl: './update-merchant.component.html',
  styleUrls: ['./update-merchant.component.css']
})
export class UpdateMerchantComponent implements OnInit {

  id: number;
  merchant: Merchant;
  submitted = false;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private merchantService: MerchantService) { }

  ngOnInit() {
    this.submitted = false;
    this.merchant = new Merchant();
    this.id = this.route.snapshot.params['id'];

    this.merchantService.getMerchantById(this.id).subscribe(
      data => {
        console.log(data);
        this.merchant = data as Merchant;
      },
      error => console.error(error)
    );
  }

  onSubmit() {
    this.submitted = true;
    this.updateMerchant();
  }

  updateMerchant() {
    this.merchantService.updateMerchant(this.id, this.merchant).subscribe(
      data => {
        console.log(data);
      },
      error => console.error(error)
    );

    this.merchant = new Merchant();
    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/merchant-list']);
  }

}
