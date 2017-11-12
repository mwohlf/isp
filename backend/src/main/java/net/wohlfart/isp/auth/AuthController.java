package net.wohlfart.isp.auth;


import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

@Api
@Slf4j
@Controller
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest login) {

        log.info("<authenticate> for user {}/{}", login.getUsername(), login.getPassword());


        // TODO: setup X-AUTH-TOKEN

        return ResponseEntity.ok(new AuthenticationResponse("ok"));
    }

    @Data
    @AllArgsConstructor
    public static class  AuthenticationRequest implements Serializable {

        String username;
        String password;

    }

    @Data
    @AllArgsConstructor
    public static class AuthenticationResponse implements Serializable {

        String token;

    }

}
