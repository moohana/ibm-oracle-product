import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { SignupComponent } from "./signup/signup.component";
import { LoginComponent } from "./login/login.component";
import { UserdashboardComponent } from "./userdashboard/userdashboard.component";
import { AdmindashboardComponent } from "./admindashboard/admindashboard.component";
import { AuthGuard } from "./auth.guard";
import { ChatBotHomepageComponent } from "./chat-bot-homepage/chat-bot-homepage.component";

const routes: Routes = [
  { path: "home", component: HomeComponent },
  { path: "signup", component: SignupComponent },
  { path: "login", component: LoginComponent },
  { path: "chatbot", component: ChatBotHomepageComponent },
  {
    path: "admindashboard",
    component: AdmindashboardComponent,
    canActivate: [AuthGuard]
  },
  { path: "userdashboard", component: UserdashboardComponent },
  { path: "**", pathMatch: "full", redirectTo: "home" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
