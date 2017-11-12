package net.wohlfart.isp.configuration;

// see: https://stackoverflow.com/questions/28658735/what-are-keycloaks-oauth2-openid-connect-endpoints

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;


// http://localhost:8001/auth/realms/isp/.well-known/openid-configuration
@Component
public class KeycloakConfig {

    private static final String OPENID_CONFIG = ".well-known/openid-configuration";

    @Value("${keycloak.auth-server-url}")
    String url;

    @Value("${keycloak.realm}")
    String realm;


    @PostConstruct
    public void readConfig() {
        RestTemplate restTemplate = new RestTemplate();
        HashMap result = restTemplate.getForObject(endpoint(), HashMap.class);
        System.out.println("result:    " + result);
    }

    public String endpoint() {
        return url + "/realms/" + realm + "/" + OPENID_CONFIG;
    }

}
