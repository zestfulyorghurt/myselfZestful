import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LayoutComponent} from './layout.component';
import { LoginGuard } from './routing';

const routes: Routes = [
    {
        path: '',
        component: LayoutComponent,
        canActivate: [LoginGuard],
        children: [
            { path: 'welcome', loadChildren: () => import('../welcome/welcome.module').then(m => m.WelcomeModule) },
            { path: 'addstaff', loadChildren: () => import('../add-staff/add-staff.module').then(m => m.AddStaffModule) }
        ]
    }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { 
}
