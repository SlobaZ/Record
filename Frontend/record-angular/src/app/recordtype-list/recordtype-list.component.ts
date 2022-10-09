import { Component, OnInit } from '@angular/core';
import { RecordType } from '../class/recordtype'
import { RecordTypeService } from '../services/recordtype.service'
import { Router } from '@angular/router';
import { TokenStorageService } from '../services/token-storage.service';


@Component({
  selector: 'app-recordtype-list',
  templateUrl: './recordtype-list.component.html',
  styleUrls: ['./recordtype-list.component.css']
})
export class RecordTypeListComponent implements OnInit {
	
  private roles: string[] = [];
  isLoggedIn = false;
  showAdmin = false;
  showUser = false;

  name='';

  recordtypes?: RecordType[]; 

  constructor(private RecordTypeService: RecordTypeService, private tokenStorageService: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
	 this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdmin = this.roles.includes('ROLE_ADMIN');
      this.showUser = this.roles.includes('ROLE_USER');

    }

    this.getRecordTypes();
  }

  private getRecordTypes(){
    this.RecordTypeService.getRecordTypesList().subscribe(data => {
      this.recordtypes = data;
    });
  }


  addRecordType(){
	this.router.navigate(['create-recordtype']);
	}

  updateRecordType(id: any){
    this.router.navigate(['update-recordtype', id]);
  }

  deleteRecordType(id: any){
    this.RecordTypeService.deleteRecordType(id).subscribe( data => {
      console.log(data);
      this.getRecordTypes();
    })
  }

	searchRecordTypes(): void {
    this.RecordTypeService.findRecordTypeByName(this.name).subscribe(data => {
      this.recordtypes = data;
    });
  }


  selectRecordType(id: any){
    this.router.navigate(['recordvalues', id]);
  }


 	excel() {
    this.RecordTypeService.excel().subscribe();
   }



}
