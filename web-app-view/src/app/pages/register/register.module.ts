import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from './register.component';
import { registerRoutingModule } from './register-routing.module';
import { NzFormModule } from 'ng-zorro-antd/form';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzCardModule } from 'ng-zorro-antd/card';

@NgModule({
  declarations: [
    RegisterComponent
  ],
  imports: [
    CommonModule,
    registerRoutingModule,
    NzFormModule,
    FormsModule,
    NzInputModule,
    NzSelectModule,
    ReactiveFormsModule,
    NzButtonModule,
    NzCardModule
  ]
})
export class RegisterModule { }
