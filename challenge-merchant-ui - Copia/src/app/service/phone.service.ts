import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PhoneService {

  private baseUrl = `${environment.apiUrl}/api/v1/merchants`;

  constructor(private http: HttpClient) { }

  getPhonesMerchant(idMerchant: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${idMerchant}/phones`);
  }

  deletePhone(idMerchant: number, idPhone: number): Observable<any> {
    console.log('DELETE PHONE');
    console.log(`${this.baseUrl}/${idMerchant}/phones/${idPhone}`);
    return this.http.delete(`${this.baseUrl}/${idMerchant}/phones/${idPhone}`);
  }

  updatePhone(idMerchant: number, idPhone: number, phone: any): Observable<Object> {
    console.log('UPDATE PHONE');
    console.log(`${this.baseUrl}/${idMerchant}/phones/${idPhone}`);
    return this.http.put(`${this.baseUrl}/${idMerchant}/phones/${idPhone}`, phone);
  }

}
