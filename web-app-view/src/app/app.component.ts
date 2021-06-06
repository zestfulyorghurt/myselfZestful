import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  static waitfunction() {
    
  }
  // wait = false
  isCollapsed = false
  static wait2: boolean
  public wait:boolean = false
  // constructor(public http:HttpClient) {
  //   const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
  //   var api = "/login.html"
    // var api = "/zestfulyoghurt/login"
  // this.http.get(api,httpOptions).subscribe(response => {
  // })
  // }
  
}
