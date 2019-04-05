import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';



@Component({
  selector: 'app-sendquery',
  templateUrl: './sendquery.component.html',
  styleUrls: ['./sendquery.component.css']
})
export class SendqueryComponent implements OnInit {
  public query: any = {};  
  public output :any;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }
  saveQuery(query:any,queryForm:any){ 
    query.answer="No answer";
    query.status=0;
    console.log(query);
    
    this.userService.savedQuery(query).subscribe((response)=>{
        if(response){
          console.log(response);
          this.output="Question send Successfully";
          queryForm.reset();
        }
        else
        {
          this.output="sorry something went wrong";
        }
    })
  }
}
