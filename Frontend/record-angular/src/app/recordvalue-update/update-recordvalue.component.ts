import { Component, OnInit } from '@angular/core';
import { RecordValueService } from '../services/recordvalue.service';
import { RecordValue } from '../class/recordvalue';
import { RecordType } from '../class/recordtype';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-update-recordvalue',
  templateUrl: './update-recordvalue.component.html',
  styleUrls: ['./update-recordvalue.component.css']
})
export class UpdateRecordValueComponent implements OnInit { 
	
  private roles: string[] = [];
  isLoggedIn = false;
  showAdmin = false;
  showUser = false;
  username?: string;
 
  
  recordTypeId?:any;
  id?:any;
  recordvalue: RecordValue = new RecordValue();
  recordtype: RecordType = new RecordType();

  constructor(private recordValueService: RecordValueService, private tokenStorageService: TokenStorageService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
	this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdmin = this.roles.includes('ROLE_ADMIN');
      this.showUser = this.roles.includes('ROLE_USER');

      this.username = user.username;
    }


	this.recordTypeId = this.route.snapshot.params['recordTypeId'];
    this.id = this.route.snapshot.params['id'];

	this.getRecordTypes();

    this.recordValueService.getRecordValueById(this.recordTypeId,this.id).subscribe(data => {
      this.recordvalue = data;
    }, error => console.log(error));
  }
 
  onSubmit(){
    this.recordValueService.updateRecordValue(this.recordTypeId, this.id, this.recordvalue).subscribe( data =>{
      this.goToRecordValueList(this.recordTypeId);
    }
    , error => console.log(error));
  }

  getRecordTypes(){ 
	this.recordTypeId = this.route.snapshot.params['recordTypeId'];
    this.recordValueService.getRecordType(this.recordTypeId).subscribe(data => {
      this.recordtype = data;
    }, error => console.log(error));
  }  

  goToRecordValueList(id: any){
    this.router.navigate(['recordvalues', id]);
  }

  cancel(){
	this.goToRecordValueList(this.recordTypeId);
  }


}
