import { Component, OnInit } from '@angular/core';
import { RecordValue } from '../class/recordvalue';
import { RecordType } from '../class/recordtype';
import { RecordValueService } from '../services/recordvalue.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-recordvalue-list',
  templateUrl: './recordvalue-list.component.html',
  styleUrls: ['./recordvalue-list.component.css']
})
export class RecordValueListComponent implements OnInit {

  private roles: string[] = [];
  isLoggedIn = false;
  showAdmin = false;
  showUser = false;

  name='';

  recordTypeId?:any;
  recordvalues?: RecordValue[]; 
  recordtype: RecordType = new RecordType();

  constructor(private recordValueService: RecordValueService, private tokenStorageService: TokenStorageService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
	 this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdmin = this.roles.includes('ROLE_ADMIN');
      this.showUser = this.roles.includes('ROLE_USER');

    }

	this.getRecordTypes();
    this.getRecordValues();
  }

  getRecordValues(){
	this.recordTypeId = this.route.snapshot.params['id'];
    this.recordValueService.getRecordValuesListByRecordType(this.recordTypeId).subscribe(data => {
      this.recordvalues = data;
    }, error => console.log(error));
 }

  getRecordTypes(){
	this.recordTypeId = this.route.snapshot.params['id'];
    this.recordValueService.getRecordType(this.recordTypeId).subscribe(data => {
      this.recordtype = data;
    }, error => console.log(error));
  }  

  addRecordValue(){
	this.recordTypeId = this.route.snapshot.params['id'];
	this.router.navigate(['create-recordvalue',this.recordTypeId]);
	}

  updateRecordValue(id: any){
	this.recordTypeId = this.route.snapshot.params['id'];
    this.router.navigate(['update-recordvalue',this.recordTypeId, id]);
  }

  deleteRecordValue(id: any){
	this.recordTypeId = this.route.snapshot.params['id'];
    this.recordValueService.deleteRecordValue(this.recordTypeId,id).subscribe( data => {
      console.log(data);
      this.getRecordValues();
    })
  }

  searchRecordValues(): void {
	this.recordTypeId = this.route.snapshot.params['id'];
    this.recordValueService.findRecordValueByName(this.recordTypeId,this.name).subscribe(data => {
      this.recordvalues = data;
    });
  }



	excel() {
		this.recordTypeId = this.route.snapshot.params['id'];
    	this.recordValueService.excel(this.recordTypeId).subscribe();
   }

  
}
