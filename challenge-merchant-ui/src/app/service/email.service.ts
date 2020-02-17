import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  private baseUrl = `${environment.apiUrl}/api/v1/merchants`;

  constructor(private http: HttpClient) { }

  getEmailsMerchant(idMerchant: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${idMerchant}/emails`);
  }

  deleteEmail(idMerchant: number, idEmail: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${idMerchant}/emails/${idEmail}`);
  }

  updateEmail(idMerchant: number, idEmail: number, email: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${idMerchant}/emails/${idEmail}`, email);
  }

}
