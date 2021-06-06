import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  constructor() { }
  isCollapsed = false
  static wait2: boolean
  public wait:boolean = false
  ngOnInit(): void {
  }

}
