import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MessageService} from 'primeng/api';
import {ToastModule} from 'primeng/toast';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from "@angular/forms";
import { CreateMerchantComponent } from './component/merchant/create-merchant/create-merchant.component';
import { DetailsMerchantComponent } from './component/merchant/details-merchant/details-merchant.component';
import { ListMerchantComponent } from './component/merchant/list-merchant/list-merchant.component';
import { UpdateMerchantComponent } from './component/merchant/update-merchant/update-merchant.component';
import { HttpClientModule } from "@angular/common/http";

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
    ToastModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
