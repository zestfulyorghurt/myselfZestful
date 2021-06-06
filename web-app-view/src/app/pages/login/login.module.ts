import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'
import { FormsModule } from '@angular/forms'
import { LoginComponent } from './login.component'
import { loginRoutingModule } from './login-routing.module'
import { NzInputModule } from 'ng-zorro-antd/input'
import { NzCheckboxModule } from 'ng-zorro-antd/checkbox'
import { NzButtonModule } from 'ng-zorro-antd/button'
import { HttpClientModule } from '@angular/common/http'
import { NzAlertModule } from 'ng-zorro-antd/alert'

@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    loginRoutingModule,
    NzInputModule,
    NzCheckboxModule,
    NzButtonModule,
    HttpClientModule,
    NzAlertModule
  ]
})
export class LoginModule { }
