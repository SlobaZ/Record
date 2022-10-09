import { Component, OnInit } from '@angular/core';
import { RecordValue } from '../class/recordvalue';
import { RecordType } from '../class/recordtype';
import { RecordValueService } from '../services/recordvalue.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-create-recordvalue',
  templateUrl: './create-recordvalue.component.html',
  styleUrls: ['./create-recordvalue.component.css']
})
export class CreateRecordValueComponent implements OnInit {
	
  private roles: string[] = [];
  isLoggedIn = false;
  showAdmin = false;
  showUser = false;
  username?: string;

  recordTypeId?:any;
  recordvalue: RecordValue = new RecordValue();
  recordtype: RecordType = new RecordType();
  constructor(private recordValueService: RecordValueService, private tokenStorageService: TokenStorageService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
	 this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdmin = this.roles.includes('ROLE_ADMIN');
      this.showUser = this.roles.includes('ROLE_USER');

      this.username = user.username;
    }

	this.getRecordTypes();
  }

 getRecordTypes(){
	this.recordTypeId = this.route.snapshot.params['id'];
    this.recordValueService.getRecordType(this.recordTypeId).subscribe(data => {
      this.recordtype = data;
    }, error => console.log(error));
  }  


  saveRecordValue(){
	this.recordTypeId = this.route.snapshot.params['id'];
    this.recordValueService.createRecordValue(this.recordTypeId, this.recordvalue).subscribe( data =>{
      console.log(data);
      this.goToRecordValueList(this.recordTypeId);
    },
    error => console.log(error));
  }

  goToRecordValueList(id: any){
    this.router.navigate(['recordvalues', id]);
  }
  
  onSubmit(){
    console.log(this.recordvalue);
    this.saveRecordValue();
  }

  cancel(){
	this.goToRecordValueList(this.recordTypeId);
 }



}
