import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { DragDropModule } from "@angular/cdk/drag-drop";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { SendqueryComponent } from "./sendquery/sendquery.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { HomeComponent } from "./home/home.component";
import { SignupComponent } from "./signup/signup.component";
import { LoginComponent } from "./login/login.component";
import { HttpClientModule } from "@angular/common/http";
import { UserService } from "./user.service";
import { AuthGuard } from "./auth.guard";
import { ChatBotHomepageComponent } from "./chat-bot-homepage/chat-bot-homepage.component";
import { MatButtonModule, MatSidenavModule } from "@angular/material";
import { UserdashboardComponent } from "./userdashboard/userdashboard.component";
import { AdmindashboardComponent } from "./admindashboard/admindashboard.component";

@NgModule({
  declarations: [
    AppComponent,
    SendqueryComponent,
    DashboardComponent,
    HomeComponent,
    SignupComponent,
    LoginComponent,
    ChatBotHomepageComponent,
    UserdashboardComponent,
    AdmindashboardComponent
  ],

  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    DragDropModule,
    MatSidenavModule,
    MatButtonModule
  ],
  providers: [UserService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule {}
