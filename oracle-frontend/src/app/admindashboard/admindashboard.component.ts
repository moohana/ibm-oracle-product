import { Component, OnInit } from "@angular/core";
import { UserService } from "../user.service";
import { LoginAuthenticationService } from "../login-authentication.service";

@Component({
  selector: "app-admindashboard",
  templateUrl: "./admindashboard.component.html",
  styleUrls: ["./admindashboard.component.css"]
})
export class AdmindashboardComponent implements OnInit {
  public loginuser: any = {};
  public users: any = [];

  constructor(
    private authService: LoginAuthenticationService,
    private userService: UserService
  ) {
    this.authService.isLoggedIn();
    this.loginuser = JSON.parse(localStorage.getItem("currentUser"));
  }

  ngOnInit() {
    this.userService.getAllUsers(this.loginuser.token).subscribe(users => {
      this.users = users;
    });
  }
}
