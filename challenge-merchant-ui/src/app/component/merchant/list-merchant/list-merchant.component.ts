import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Router} from '@angular/router';
import {Merchant} from "../../../model/merchant";
import {MerchantService} from "../../../service/merchant.service";

@Component({
  selector: 'app-list-merchant',
  templateUrl: './list-merchant.component.html',
  styleUrls: ['./list-merchant.component.css']
})
export class ListMerchantComponent implements OnInit {

  merchants: Observable<Merchant[]>;

  constructor(private merchantService: MerchantService,
              private router: Router) {
  }

  ngOnInit() {
    this.getAllMerchants();
  }

  getAllMerchants() {
    this.merchants = this.merchantService.getAllMerchants();
  }

  merchantDetail(id: number) {
    this.router.navigate(['merchant-details', id]);
  }

  deleteMerchant(id: number) {
    this.merchantService.deleteMerchant(id)
      .subscribe(
        data => {
          this.getAllMerchants();
        },
        error => console.log(error));
  }

}
