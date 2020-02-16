import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListMerchantComponent} from "./component/merchant/list-merchant/list-merchant.component";
import {CreateMerchantComponent} from "./component/merchant/create-merchant/create-merchant.component";
import {UpdateMerchantComponent} from "./component/merchant/update-merchant/update-merchant.component";
import {DetailsMerchantComponent} from "./component/merchant/details-merchant/details-merchant.component";


const routes: Routes = [

  { path: '', redirectTo: 'merchant', pathMatch: 'full' },
  { path: 'merchant-list', component: ListMerchantComponent },
  { path: 'merchant-create', component: CreateMerchantComponent },
  { path: 'merchant-update/:id', component: UpdateMerchantComponent },
  { path: 'merchant-details/:id', component: DetailsMerchantComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
