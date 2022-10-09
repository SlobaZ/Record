import { Component, OnInit } from '@angular/core';
import { RecordTypeService } from '../services/recordtype.service';
import { RecordType } from '../class/recordtype';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-update-recordtype',
  templateUrl: './update-recordtype.component.html',
  styleUrls: ['./update-recordtype.component.css']
})
export class UpdateRecordTypeComponent implements OnInit { 
	
  private roles: string[] = [];
  isLoggedIn = false;
  showAdmin = false;
  showUser = false;
  username?: string;
 
  id?: any;
  recordtype: RecordType = new RecordType();
  constructor(private RecordTypeService: RecordTypeService, private tokenStorageService: TokenStorageService,
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

    this.id = this.route.snapshot.params['id'];

    this.RecordTypeService.getRecordTypeById(this.id).subscribe(data => {
      this.recordtype = data;
    }, error => console.log(error));
  }
 
  onSubmit(){
    this.RecordTypeService.updateRecordType(this.id, this.recordtype).subscribe( data =>{
      this.goToRecordTypeList();
    }
    , error => console.log(error));
  }

  goToRecordTypeList(){
    this.router.navigate(['/recordtypes']);
  }

  cancel(){
	this.goToRecordTypeList();
  }


}
