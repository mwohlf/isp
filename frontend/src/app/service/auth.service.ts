import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {AuthControllerService} from "../../generated/api/authController.service";
import {AuthenticationRequest} from "../../generated/model/authenticationRequest";

@Injectable()
export class AuthService {

  constructor(private authControllerService: AuthControllerService) { }

  login(username: string, password: string): Observable<Boolean> {
    var request: AuthenticationRequest = {
      username: username,
      password: password
    };

    return this.authControllerService.authenticateUsingPOST(request)
      .map(
        tokenResponse => {
          console.log("response" + tokenResponse);
          return Observable.create(true);
        })
      .catch(
        error => {
          // this.updateTokenAndSubject();
          return Observable.throw(error);
        });

  }

}
