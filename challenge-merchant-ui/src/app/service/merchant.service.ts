import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MerchantService {

  private baseUrl = 'http://localhost:8080/challenge-merchant-api/api/v1/merchants/';

  constructor(private http: HttpClient) { }

  getAllMerchants(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getMerchantById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createMerchant(merchant: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, merchant);
  }

  updateMerchant(id: number, merchant: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, merchant);
  }

  deleteMerchant(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

}
