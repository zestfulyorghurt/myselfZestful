import { NgModule } from '@angular/core';

import {CommonModule} from '@angular/common';

import { WelcomeRoutingModule } from './welcome-routing.module';

import { WelcomeComponent } from './welcome.component';

import { FormsModule } from '@angular/forms';

import { NzInputModule } from 'ng-zorro-antd/input';

import { NzRadioModule } from 'ng-zorro-antd/radio';
//引入Module模态框
import { NzModalModule } from 'ng-zorro-antd/modal';
//添加用户等待转圈界面
import { NzSpinModule } from 'ng-zorro-antd/spin';

import { NzInputNumberModule } from 'ng-zorro-antd/input-number';
//提示框包
import { NzPopconfirmModule } from 'ng-zorro-antd/popconfirm';
@NgModule({
  imports: [WelcomeRoutingModule,CommonModule,FormsModule,NzModalModule,NzInputModule,NzRadioModule,NzSpinModule,NzInputNumberModule,NzPopconfirmModule],
  declarations: [WelcomeComponent],
  exports: [WelcomeComponent]
})
export class WelcomeModule { }
