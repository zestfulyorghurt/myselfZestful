import { Component, OnInit } from '@angular/core'
//引入HttpClient实现前后端通信
import {HttpClient,HttpHeaders} from "@angular/common/http"
import { en_US, NzI18nService, zh_CN } from 'ng-zorro-antd/i18n'

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  //model
  model = false
  wait = false
  //定义姓名
  name = ""
  //定义分页选中后样式发生改变得数组
  paging_select:boolean[] = []
  //定义输入框验证因子
  validate_name = false
  validate_age = false
  validate_email = false
  validate_tel = false
  validate_joinTime = false
  //定义当前页和每次查询数据条数
  page_info = {current_page:1,data_number:8}
  //定义性别下拉框属性
  select_sex = ["全部","男","女"]
  select__sex_data = "全部"
  //定义年龄下拉框属性:将年龄段分为4个阶段
  select_age = ["18-","18-23","24-30","31-40","40-"]
  select__age_data = "18-"
  //定义表格头的内容
  table_heard = ["员工姓名","员工年龄","员工性别","员工邮箱","员工电话","入职时间","操作"]
  //定义员工信息
  staff_info = null
  //定义总页数
  paging = []
  //定义分页因子，当点击查询时会改变改值，让分页方法中的逻辑发生对应改变，变成条件专属的分页，点击取消查询时会将值恢复原值
  paging_divisor = 0
  //定义请求参数
  reqData = {name:'',age:'',sex:'',current_page:1,data_number:8}
  //声明对应的构造方法HttpClient，来实现前后端数据的传递172.29.140.135;初始化界面
  constructor(public http:HttpClient,private i18n: NzI18nService) {
    //画面初始化加载渲染 
     this.Frame("/zestfulyoghurt/getResourceStaff",this.page_info)
    //this.Frame("/getResourceStaff",this.page_info)
  }
  //分页:分为含条件的分页和普通查询的分页，根据paging_divisor进行判断
 change_page(index:any){
   if(this.paging_divisor==0){
   if(index == -1){
     //上一页
     this.page_info.current_page = this.page_info.current_page-1
     if(this.page_info.current_page>0){
        this.Frame("/zestfulyoghurt/getResourceStaff",this.page_info)
     }else{
      this.page_info.current_page = this.page_info.current_page+1
      this.paging_select[this.page_info.current_page-1] = true
     }
   }else if(index == -2){
     //下一页
     this.page_info.current_page = this.page_info.current_page+1
     if(this.page_info.current_page==this.paging.length||this.page_info.current_page<this.paging.length){
        this.Frame("/zestfulyoghurt/getResourceStaff",this.page_info)
     }else{
      this.page_info.current_page = this.page_info.current_page-1
      this.paging_select[this.page_info.current_page-1] = true
      alert("最后一页")
     }
   }else{
   //指定页
   this.page_info.current_page = index+1
   this.Frame("/zestfulyoghurt/getResourceStaff",this.page_info)  
  }
 }else{
  if(index == -1){
    //上一页
    this.reqData.current_page = this.reqData.current_page-1
    if(this.reqData.current_page>0){
       this.Frame("/zestfulyoghurt/getResourceStaffCondition",this.reqData)
    }else{
     this.reqData.current_page = this.reqData.current_page+1
    }
  }else if(index == -2){
    //下一页
    this.reqData.current_page = this.reqData.current_page+1
    if(this.reqData.current_page==this.paging.length||this.reqData.current_page<this.paging.length){
       this.Frame("/zestfulyoghurt/getResourceStaffCondition",this.reqData)
    }else{
     this.reqData.current_page = this.reqData.current_page-1
     alert("最后一页")
    }
  }else{
  //指定页
  this.reqData.current_page = index+1
  this.Frame("/zestfulyoghurt/getResourceStaffCondition",this.reqData)  
 }
}
}
 //按照条件检索信息
 conditions_for_retrieval(){
  this.reqData = {name:this.name,age:this.select__age_data,sex:this.select__sex_data,current_page:1,data_number:8}
  this.paging_divisor = 1
  console.log(this.reqData)
  this.Frame("/zestfulyoghurt/getResourceStaffCondition",this.reqData) 
 }
 //取消检索
 cancel_the_retrieval(){
  this.page_info = {current_page:1,data_number:8}
  this.paging_divisor = 0
  this.Frame("/zestfulyoghurt/getResourceStaff",this.page_info)
  this.name = ""
  this.select__sex_data = "全部"
  this.select__age_data = "18-"
 }
 //删除员工信息
 delete_staff_info(id:any){
  this.wait=true
  const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
  var api = "/zestfulyoghurt/deleteStaffInfo"
  this.http.post(api,id,httpOptions).subscribe(response => {
    //在ts中无法出现类型问题，直接将类型定义为any
    console.log(response)
    let responseData:any = response
    alert(responseData.Message)
    // this.page_info = {current_page:1,data_number:8}
    this.Frame("/zestfulyoghurt/getResourceStaff",this.page_info)
  })
 }
 //Module对话框蚂蚁金服
 isVisible = false;

 modal_p_name = "姓名"

 modal_p_age = "年龄"

 modal_p_sex = "性别"

 modal_label_man = "男"

 modal_label_woman = "女"

 modal_p_email = "邮箱"

 modal_p_tel = "电话"

 modal_p_joinTime = "入职时间"

 //定义双向绑定属性
 modal_rudio_sex = "0"

 modal_input_name = ""

 modal_input_age = ""

 modal_input_email = ""

 modal_input_tel = ""

 modal_input_joinTime = ""

 //定义员工的id通过id后端进行相关操作
 staff_id = ""
 //点击让修改员工的模态框显示
 showModal(id:any): void {
   this.model = true
   this.staff_id = id
   this.isVisible = true;
 }

//模态框中的确定选项被点击事件
 handleOk(): void {
  let if_count = true
  if(this.modal_input_name==""){
    this.validate_name=true
    if_count = false
  }else{
    this.validate_name=false
  }
  if(this.modal_input_age==""){
    this.validate_age=true
    if_count = false
  }else{
    this.validate_age=false
  }
  if(this.modal_input_email==""){
    this.validate_email=true
    if_count = false
  }else{
    this.validate_email=false
  }
  if(this.modal_input_tel==""){
    this.validate_tel=true
    if_count = false
  }else{
    this.validate_tel=false
  }
  if(this.modal_input_joinTime==""){
    this.validate_joinTime=true
    if_count = false
  }else{
    this.validate_joinTime=false
  }
  if(if_count){
     this.wait=true
     this.model = false
     this.validate_joinTime=false
     this.validate_tel=false
     this.validate_email=false
     this.validate_age=false
     this.validate_name=false
     let reqData:any = {id:this.staff_id,name:this.modal_input_name,age:this.modal_input_age,sex:this.modal_rudio_sex,email:this.modal_input_email,tel:this.modal_input_tel,joinTime:this.modal_input_joinTime}
     this.wait=true
     const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
     this.http.post("/zestfulyoghurt/updateStaffInfo",reqData,httpOptions).subscribe(response => {
     let responseData:any = response 
     alert(responseData.Message)
     //修改员工信息成功，刷新界面
     if(this.paging_divisor == 0){
      this.Frame("/zestfulyoghurt/getResourceStaff",this.page_info)
     }else{
      this.Frame("/zestfulyoghurt/getResourceStaff",this.reqData)
     }
    })
    this.modal_rudio_sex = "0"
    this.modal_input_name = ""
    this.modal_input_age = ""
    this.modal_input_email = ""    
    this.modal_input_tel = ""  
    this.modal_input_joinTime = ""   
    this.isVisible = false
    this.staff_id = ""
  }else{
    alert("请将信息填写完整")
  }
 }
//模态框中的取消按钮被点击事件
 handleCancel(): void {
  this.model = false
  this.validate_joinTime=false
  this.validate_tel=false
  this.validate_email=false
  this.validate_age=false
  this.validate_name=false
  this.model = false
  this.modal_rudio_sex = "0"
  this.modal_input_name = ""
  this.modal_input_age = ""
  this.modal_input_email = ""
  this.modal_input_tel = ""
  this.modal_input_joinTime = ""
  this.isVisible = false
  this.staff_id = ""
 }

//渲染画面
 Frame(url:any,data:any){
  this.wait=true
  const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }
  var api = url
  this.http.post(api,data,httpOptions).subscribe(response => {
    console.log(response)
    this.wait=false
    var responseData:any = response
    for(var i= 0;i<responseData.staffInfo.length;i++) {
      if(responseData.staffInfo[i].sex==0){
        responseData.staffInfo[i].sex="男"
       }else{
        responseData.staffInfo[i].sex="女"
       }
    }
    let count_d:boolean[] = []
    for(var i = 0; i<responseData.paging.length;i++){
      if(i==(data.current_page-1)){
        count_d.push(true)
      }else{
        count_d.push(false)
      }
    }
    this.paging_select = count_d
    this.staff_info = responseData.staffInfo
    this.paging = responseData.paging
    if(responseData.staffInfo.length==0){
      alert("员工信息为空！")
    }
  })
 }
  ngOnInit() { 
  }
}


