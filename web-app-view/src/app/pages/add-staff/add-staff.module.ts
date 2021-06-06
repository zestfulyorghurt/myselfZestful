import { NgModule } from '@angular/core'
import { CommonModule } from '@angular/common'
import { AddStaffComponent } from './add-staff.component'
import {addStaffRoutingModule} from './add-staff-routing.module'

@NgModule({
  declarations: [
    AddStaffComponent
  ],
  imports: [
    CommonModule,addStaffRoutingModule
  ],
  exports: [AddStaffComponent]
})
export class AddStaffModule { }
