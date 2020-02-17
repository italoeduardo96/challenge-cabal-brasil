import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListMerchantComponent} from "./component/merchant/list-merchant/list-merchant.component";
import {CreateMerchantComponent} from "./component/merchant/create-merchant/create-merchant.component";
import {DetailsMerchantComponent} from "./component/merchant/details-merchant/details-merchant.component";


const routes: Routes = [
  { path: '', redirectTo: 'merchant-list', pathMatch: 'full' },
  { path: 'merchant-list', component: ListMerchantComponent },
  { path: 'merchant-create', component: CreateMerchantComponent },
  { path: 'merchant-update/:id', component: CreateMerchantComponent },
  { path: 'merchant-details/:id', component: DetailsMerchantComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
