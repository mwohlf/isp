import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";

import {AppComponent} from './app.component';
import {NavbarComponent} from './component/navbar/navbar.component';
import {FooterComponent} from './component/footer/footer.component';
import {LoginComponent} from './component/login/login.component';
import {LogoutComponent} from './component/logout/logout.component';
import {AboutComponent} from './component/about/about.component';
import {DefaultComponent} from './component/default/default.component';
import {StartComponent} from './component/start/start.component';
import {AuthService} from "./service/auth.service";
import {Backend} from "./backend";
import {Routing} from "./routing";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    LogoutComponent,
    AboutComponent,
    DefaultComponent,
    StartComponent,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    Routing,
    Backend,
  ],
  providers: [
    AuthService,
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
