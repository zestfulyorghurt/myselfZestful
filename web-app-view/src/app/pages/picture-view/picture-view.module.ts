import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PictureViewComponent } from './picture-view.component';
import {pictureViewRoutingModule} from './picture-view-routing.module'


@NgModule({
  declarations: [
    PictureViewComponent
  ],
  imports: [
    CommonModule,pictureViewRoutingModule
  ]
})
export class PictureViewModule { }
