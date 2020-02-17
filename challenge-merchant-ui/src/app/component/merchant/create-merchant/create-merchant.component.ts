import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { Merchant } from "../../../model/merchant";
import { MerchantService } from "../../../service/merchant.service";
import { Address } from "../../../model/address";
import { Phone } from "../../../model/phone";
import { Email } from "../../../model/email";
import {WrapperApierror} from "../../../shared/validation/wrapperApierror";
import {PhoneTypeEnum} from "../../../shared/enum/phoneTypeEnum";
import {PhoneService} from "../../../service/phone.service";
import {AddressService} from "../../../service/address.service";
import {EmailService} from "../../../service/email.service";

@Component({
  selector: 'app-create-merchant',
  templateUrl: './create-merchant.component.html',
  styleUrls: ['./create-merchant.component.css']
})
export class CreateMerchantComponent implements OnInit {

  submitted = false;
  isEdit: boolean;
  id: number;
  message: string;
  wrapperApierror: WrapperApierror;

  merchant: Merchant = new Merchant();
  phones: Phone[];
  phoneAux: Phone;

  emails: Email[];
  emailAux: Email;

  address: Address;

  private phoneTypes = PhoneTypeEnum;
  public phoneTypeOptions = [];

  constructor(private route: ActivatedRoute,
              private merchantService: MerchantService,
              private phoneService: PhoneService,
              private emailService: EmailService,
              private addressService: AddressService,
              private router: Router) { }

  ngOnInit() {
    this.initForm();
    this.id = this.route.snapshot.params['id'];

    if(this.id){
      this.isEdit = true;
      this.getInfoIsEdit();
    }
  }

  removePhoneById(idPhone: number){
    this.phoneService.deletePhone(this.id, idPhone).subscribe(
      data => {
        this.submitted = true;
        this.message = "Success to delete phone";
      },
      error => {
        this.submitted = true;
        this.message = "Error to delete phone";
        this.setWrapperApierror(error);
      }
    );
  }

  removeEmailById(idEmail: number){
    this.emailService.deleteEmail(this.id, idEmail).subscribe(
      data => {
        this.submitted = true;
        this.message = "Success to delete email";
      },
      error => {
        this.submitted = true;
        this.message = "Error to delete email";
        this.setWrapperApierror(error);
      }
    );
  }

  updateMerchant() {
    console.log('update');
    this.merchantService.updateMerchant(this.id, this.merchant).subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log(error.error);
        this.submitted = true;
        this.message = "Error to update merchant";

        this.setWrapperApierror(error);

      }
    );

   console.log('update telefones');
   this.phones.forEach(phone => {
     console.log('PhoneID: ' + phone.id);
     this.phoneService.updatePhone(this.id, phone.id, phone).subscribe(
       data => {
         console.log(data);
       }
     );
   });

    console.log('update emails');
    this.emails.forEach(email => {
      console.log('emailID: ' + email.id);
      this.emailService.updateEmail(this.id, email.id, email).subscribe(
        data => {
          console.log(data);
        }
      );
   });

    console.log('update address');
    this.addressService.updateddressMerchant(this.id, this.address.id, this.address).subscribe(
      data => {
        console.log(data);
      }
    );

    this.submitted = true;
    this.message = "Success to update merchant";
  }

  saveMerchant() {

    this.merchant.address = this.address;
    this.merchant.emails = this.emails;
    this.merchant.phones = this.phones;

    console.log(this.merchant);

    this.merchantService.createMerchant(this.merchant).subscribe(
      data => {
        console.log(data);
        this.initForm();

        this.submitted = true;
        this.message = "Success to create merchant";
      },
      error => {
        console.log(error.error);
        this.submitted = true;
        this.message = "Error to create merchant";

        this.setWrapperApierror(error);
      }
    );


  }

  addPhone() {
    this.phones.push(this.phoneAux);
    this.phoneAux = new Phone();
  }

  removePhone(index: number) {
    this.phones.splice(index, 1);
  }

  removeEmail(index: number) {
    this.emails.splice(index, 1);
  }

  addEmail() {
    this.emails.push(this.emailAux);
    this.emailAux = new Email();
  }

  findCep(){

  }

  onSubmit() {
    this.submitted = true;

    if(this.isEdit){
      this.updateMerchant();
    }else {
      this.saveMerchant();
    }
  }

  goToList() {
    this.router.navigate(['/merchant-list']);
  }

  goToAddMerchant() {
    this.submitted = false;
    this.wrapperApierror = null;
  }

  getInfoIsEdit() {
    this.getMerchant();
    this.getPhones();
    this.getEmails();
    this.getAddress();
  }

  private getMerchant() {
    this.merchantService.getMerchantById(this.id).subscribe(
      data => {
        console.log(data);
        this.merchant = data as Merchant;
      },
      error => console.error(error)
    );
  }

  private getPhones(){
    this.phoneService.getPhonesMerchant(this.id).subscribe(
      data => {
        console.log(data);
        this.phones = data as Phone[];
      },
      error => console.error(error)
    );
  }

  private getEmails(){
    this.emailService.getEmailsMerchant(this.id).subscribe(
      data => {
        console.log(data);
        this.emails = data as Email[];
      },
      error => console.error(error)
    );
  }

  private getAddress(){
    this.addressService.getAddressMerchant(this.id).subscribe(
      data => {
        console.log(data);
        this.address = data as Address;
      },
      error => console.error(error)
    );
  }

  initForm(){
    this.phoneAux = new Phone();
    this.phones = new Array();

    this.emailAux = new Email();
    this.emails = new Array();

    this.merchant = new Merchant();
    this.submitted = false;

    this.address = new Address();

    this.phoneTypeOptions = Object.keys(this.phoneTypes);
  }

  setWrapperApierror(error: any){
    this.wrapperApierror = error.error;
    if (error.error.apierror.status === 'BAD_REQUEST') {
      this.message = this.wrapperApierror.apierror.message;
    } else {
      this.message += ' ' + error.error.apierror.message;
  }


}





}
