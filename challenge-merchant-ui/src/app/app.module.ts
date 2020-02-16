import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateMerchantComponent } from './component/merchant/create-merchant/create-merchant.component';
import { DetailsMerchantComponent } from './component/merchant/details-merchant/details-merchant.component';
import { ListMerchantComponent } from './component/merchant/list-merchant/list-merchant.component';
import { UpdateMerchantComponent } from './component/merchant/update-merchant/update-merchant.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateMerchantComponent,
    DetailsMerchantComponent,
    ListMerchantComponent,
    UpdateMerchantComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
