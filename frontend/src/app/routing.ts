import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ErrorHandler} from "@angular/router/src/router";

import {LoginComponent} from "./component/login/login.component";
import {LogoutComponent} from "./component/logout/logout.component";
import {AboutComponent} from "./component/about/about.component";
import {DefaultComponent} from "./component/default/default.component";


const APP_ROUTES: Routes = [
  { path: "login", component: LoginComponent },
  { path: "logout", component: LogoutComponent },
  { path: "about", component: AboutComponent },

  { path: '**', component: DefaultComponent },
];

export const errorHandler: ErrorHandler = (error: any) => {
  console.error("routing failed, error");
  console.error(error);
};

export const Routing: ModuleWithProviders = RouterModule.forRoot(
  APP_ROUTES,
  {
    enableTracing: false,   // <-- debugging purposes only
    //  errorHandler: errorHandler
  }
);

