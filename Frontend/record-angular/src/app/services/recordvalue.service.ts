import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { RecordValue } from '../class/recordvalue';
import { RecordType } from '../class/recordtype';

@Injectable({
  providedIn: 'root'
})
export class RecordValueService {

  private baseURL = "http://localhost:8080/api/recordtypes";

  constructor(private httpClient: HttpClient) { }

  getRecordType(recordTypeId:number): Observable<RecordType>{
    return this.httpClient.get<RecordType>(`${this.baseURL}/${recordTypeId}`);
  }

  getRecordValuesListByRecordType(recordTypeId:number): Observable<RecordValue[]>{
    return this.httpClient.get<RecordValue[]>(`${this.baseURL}/${recordTypeId}/recordvalues`);
  }

  createRecordValue(recordTypeId:number, recordvalue: RecordValue): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/${recordTypeId}/recordvalues`, recordvalue);
  }

  getRecordValueById(recordTypeId:number,id: number): Observable<RecordValue>{
    return this.httpClient.get<RecordValue>(`${this.baseURL}/${recordTypeId}/recordvalues/${id}`);
  }

  updateRecordValue(recordTypeId:number, id: number, recordvalue: RecordValue): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${recordTypeId}/recordvalues/${id}`, recordvalue);
  }

  deleteRecordValue(recordTypeId:number, id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${recordTypeId}/recordvalues/${id}`);
  }

  findRecordValueByName(recordTypeId:number,name:string): Observable<RecordValue[]>{
     return this.httpClient.get<RecordValue[]>(`${this.baseURL}/${recordTypeId}/recordvalues?name=${name}`);
  }

  excel(recordTypeId:number): Observable<void>{
    return this.httpClient.get<void>(`${this.baseURL}/${recordTypeId}/recordvalues/excel`);
  }




}
