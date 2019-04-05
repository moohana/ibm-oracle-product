import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { LoginAuthenticationService } from "../login-authentication.service";

@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.css"]
})
export class DashboardComponent implements OnInit {
  public currentstatus: any;

  constructor(
    private authService: LoginAuthenticationService,
    private router: Router
  ) {
    this.currentstatus = this.authService
      .getStatus()
      .subscribe(currentstatus => {
        this.currentstatus = currentstatus;
      });
  }
  logout() {
    localStorage.removeItem("currentUser");
    this.router.navigate(["login"]);
  }
  ngOnInit() {}
}
