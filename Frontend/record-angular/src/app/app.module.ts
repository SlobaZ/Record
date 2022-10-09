import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { authInterceptorProviders } from './helpers/auth.interceptor';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    RecordTypeListComponent,
	CreateRecordTypeComponent, 
    UpdateRecordTypeComponent,
	RecordValueListComponent,
	CreateRecordValueComponent,
	UpdateRecordValueComponent,
	UserListComponent,
	UpdateUserComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
