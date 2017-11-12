package net.wohlfart.isp.security;


import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.wohlfart.isp.configuration.KeycloakConfig;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

@Api
@Slf4j
@Controller
public class LoginController {

    @Autowired
    KeycloakRestTemplate keycloakRestTemplate;

    @Autowired
    KeycloakConfig keycloakConfig;


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest login) {

        log.info("<authenticate> for user {}/{}", login.getUsername(), login.getPassword());

        this.doLogin(login.getUsername(), login.getPassword());


        keycloakConfig.toString();
        // RESULT=`curl --data
        //    "grant_type=password&
        //     client_id=curl&
        //     username=yourusername&
        //     password=*****"
        //
        // https://auth.wpic-tools.com/auth/realms/wpic/protocol/openid-connect/token`

        // TODO: setup X-AUTH-TOKEN

        return ResponseEntity.ok(new AuthenticationResponse("ok"));
    }

    private void doLogin(String username, String password) {
        Object entry = new Object();
        String endpoint = "http://localhost:8082/mail";
        Boolean result = keycloakRestTemplate.postForObject(endpoint, entry, Boolean.class);
        System.out.println("Mail sent: " + result.toString());
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
