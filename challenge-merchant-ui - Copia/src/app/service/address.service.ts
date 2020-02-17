import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AddressService {
  private baseUrl = `${environment.apiUrl}/api/v1/merchants`;

  constructor(private http: HttpClient) { }

  getAddressMerchant(idMerchant: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${idMerchant}/adresses`);
  }

  updateddressMerchant(idMerchant: number, idAddress: number, address: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${idMerchant}/adresses/${idAddress}`, address);
  }

}
