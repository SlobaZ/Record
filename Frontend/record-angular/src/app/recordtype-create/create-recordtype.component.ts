import { Component, OnInit } from '@angular/core';
import { RecordType } from '../class/recordtype';
import { RecordTypeService } from '../services/recordtype.service';
import { Router } from '@angular/router';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-create-recordtype',
  templateUrl: './create-recordtype.component.html',
  styleUrls: ['./create-recordtype.component.css']
})
export class CreateRecordTypeComponent implements OnInit {
	
  private roles: string[] = [];
  isLoggedIn = false;
  showAdmin = false;
  showUser = false;
  username?: string;

  recordtype: RecordType = new RecordType();
  constructor(private RecordTypeService: RecordTypeService, private tokenStorageService: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
	 this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdmin = this.roles.includes('ROLE_ADMIN');
      this.showUser = this.roles.includes('ROLE_USER');

      this.username = user.username;
    }
  }

  saveRecordType(){
    this.RecordTypeService.createRecordType(this.recordtype).subscribe( data =>{
      console.log(data);
      this.goToRecordTypeList();
    },
    error => console.log(error));
  }

  goToRecordTypeList(){
    this.router.navigate(['/recordtypes']);
  }
  
  onSubmit(){
    console.log(this.recordtype);
    this.saveRecordType();
  }

  cancel(){
	this.goToRecordTypeList();
  }

}
