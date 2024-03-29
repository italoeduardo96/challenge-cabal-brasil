import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {CreateMerchantComponent} from "./component/merchant/create-merchant/create-merchant.component";
import {DetailsMerchantComponent} from "./component/merchant/details-merchant/details-merchant.component";
import {ListMerchantComponent} from "./component/merchant/list-merchant/list-merchant.component";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    CreateMerchantComponent,
    DetailsMerchantComponent,
    ListMerchantComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
