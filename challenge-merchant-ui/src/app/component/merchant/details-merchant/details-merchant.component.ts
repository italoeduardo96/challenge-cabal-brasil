import { Component, OnInit, Input} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {Merchant} from "../../../model/merchant";
import {MerchantService} from "../../../service/merchant.service";

@Component({
  selector: 'app-details-merchant',
  templateUrl: './details-merchant.component.html',
  styleUrls: ['./details-merchant.component.css']
})
export class DetailsMerchantComponent implements OnInit {

  id: number;
  merchant: Merchant;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private merchantService: MerchantService) { }

  ngOnInit() {

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

  goToList(){
    this.router.navigate(['/merchant-list']);
  }

}
