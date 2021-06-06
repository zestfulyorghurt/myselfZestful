import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // 实现remberme
  rember = false

  //用户名和密码文本框登录时失去活性
  username_active_factor  = ""
  password_active_factor = ""



  login_class=false
  password = ""
  username = ""
  alert_warning = false
  alert_error = false
  alert_success = false
  constructor(private router: ActivatedRoute,private http: HttpClient,private routerc: Router ) {
    sessionStorage.clear()
    const data_default:any = this.router.queryParams 
    console.log(data_default.value.message)
    if(data_default.value.message){
      alert(data_default.value.message)
    }
  }
  data = {'usernmae':'zhangyi','password':'123'}
  public login(){    
    // 登录时的非空验证
    // if(this.username==''||this.password==''){
    //   alert('用户名和密码不能为空')
    //   return
    // }
    this.username_active_factor = "readonly"
    this.password_active_factor = "readonly"
    this.alert_error= false
    this.alert_warning= false
    this.alert_success= false
    this.login_class = true
    const req_data = {"username":this.username,"password":this.password}
    const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
    var url = "/zestfulyoghurt/loginCheckOut"
    this.http.post(url,req_data,httpOptions).subscribe(response=>{
      this.login_class = false
       const token = "789"//todo
       const response_data:any = response
       if(response_data.message == "用户名或密码错误"){
        this.alert_error = true
       }else if(response_data.message == "登录异常"){
        this.alert_warning = true
       }else{
        this.alert_success = true
        console.log("马上进行跳转")
        setTimeout(() =>{
          this.routerc.navigate(["/layout/welcome"])
        },1000)
        sessionStorage.setItem("access_token",token)
       }
       console.log(response_data)
    })
  }

  afterClose(): void {
    this.alert_warning = false
    this.alert_error = false
    this.alert_success = false
    this.username_active_factor = ""
    this.password_active_factor = ""
    console.log('close');
  } 
  ngOnInit(): void {

  }

}
