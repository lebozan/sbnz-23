import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AllDataService {

  constructor(private http: HttpClient) { }


  getAllActiveGems(): Observable<any> {
    return this.http.get('api/api/data/activeGems');
  }

  getAllSupportGems(): Observable<any> {
    return this.http.get('api/api/data/supportGems');
  }

  getAllKeystones(): Observable<any> {
    return this.http.get('api/api/data/keystones');
  }

  sendFirstEntry(entryData: object): Observable<any> {
    return this.http.post('api/api/input/firstEntry', entryData);
  }

  sendSecondEntry(entryData: object): Observable<any> {
    return this.http.post('api/api/input/second', entryData);
  }

}
