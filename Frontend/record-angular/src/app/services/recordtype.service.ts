import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { RecordType } from '../class/recordtype';

@Injectable({
  providedIn: 'root'
})
export class RecordTypeService {

  private baseURL = "http://localhost:8080/api/recordtypes";

  constructor(private httpClient: HttpClient) { }


  getRecordTypesList(): Observable<RecordType[]>{
    return this.httpClient.get<RecordType[]>(`${this.baseURL}`);
  }

  createRecordType(recordtype: RecordType): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, recordtype);
  }

  getRecordTypeById(id: number): Observable<RecordType>{
    return this.httpClient.get<RecordType>(`${this.baseURL}/${id}`);
  }

  updateRecordType(id: number, recordtype: RecordType): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, recordtype);
  }

  deleteRecordType(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

  findRecordTypeByName(name:string): Observable<RecordType[]>{
     return this.httpClient.get<RecordType[]>(`${this.baseURL}?name=${name}`);
  }

  excel(): Observable<void>{
    return this.httpClient.get<void>(`${this.baseURL}/excel`);
  }



}
