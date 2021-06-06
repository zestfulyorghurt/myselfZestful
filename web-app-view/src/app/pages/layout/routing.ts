import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
@Injectable({ providedIn: 'root'})

export class LoginGuard implements CanActivate {  
    
    constructor(private router: Router) {

    }

    canActivate (next: ActivatedRouteSnapshot, state: RouterStateSnapshot):boolean {    	
        return this.login_check()
    }

    login_check(): boolean{
        const token = sessionStorage.getItem('access_token')
        if(token){
            return true
        } 
        this.router.navigate(['login'],{ queryParams: { message: "请先登录" } })
        return false
    }

}
