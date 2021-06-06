import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PictureViewComponent } from './picture-view.component';

const routes: Routes = [
  { path: '', component: PictureViewComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class pictureViewRoutingModule { }
