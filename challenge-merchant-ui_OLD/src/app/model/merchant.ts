import {Phone} from "./phone";
import {Email} from "./email";
import {Address} from "./address";

export class Merchant {
  id: number;
  nmMerchant: string;
  nuDocument: string;
  dtInsert: string;
  dtLastUpdate: string;

  phones: Phone[] = [];
  emails: Email[] = [];
  address: Address;

  constructor() {
    this.nmMerchant = '';
    this.nuDocument = ''

    this.address = new Address();
  }
}
