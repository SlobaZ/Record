import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RecordTypeListComponent } from './recordtype-list/recordtype-list.component';
import { CreateRecordTypeComponent } from './recordtype-create/create-recordtype.component';
import { UpdateRecordTypeComponent } from './recordtype-update/update-recordtype.component';
import { RecordValueListComponent } from './recordvalue-list/recordvalue-list.component';
import { CreateRecordValueComponent } from './recordvalue-create/create-recordvalue.component';
import { UpdateRecordValueComponent } from './recordvalue-update/update-recordvalue.component';
import { UserListComponent } from './user-list/user-list.component';
import { UpdateUserComponent } from './user-update/update-user.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'recordtypes', component: RecordTypeListComponent },
  { path: 'create-recordtype', component: CreateRecordTypeComponent},
  { path: 'update-recordtype/:id', component: UpdateRecordTypeComponent},
  { path: 'recordvalues/:id', component: RecordValueListComponent },
  { path: 'create-recordvalue/:id', component: CreateRecordValueComponent},
  { path: 'update-recordvalue/:recordTypeId/:id', component: UpdateRecordValueComponent},
  { path: 'users', component: UserListComponent},
  { path: 'update-user/:id', component: UpdateUserComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
