package com.example.demo.controller;

import com.example.demo.dto.PayloadDto;
import com.example.demo.properties.ClientProperties;
import com.example.demo.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/auth")
public class AuthController {

    public static String baseUrl = "test.devenv.smartym.by";

    private final AuthorizationService authorizationService;
    private final ClientProperties clientProperties;


    public AuthController(final AuthorizationService authorizationService, ClientProperties clientProperties) {
        this.authorizationService = authorizationService;
        this.clientProperties = clientProperties;
    }

    @GetMapping("/signIn")
    public RedirectView signIn() {
        return new RedirectView(UriComponentsBuilder.newInstance()
                .host(baseUrl)
                .path("/signin")
                .queryParam("client_id", clientProperties.getClientId())
                .queryParam("redirect_uri", clientProperties.getRedirectUri())
                .queryParam("response_type", "code")
                .queryParam("scope", "aisp")
                .queryParam("state", clientProperties.getState())
                .build()
                .toString());
    }

    @GetMapping("/token")
    public String getToken(@RequestParam("state") String state, @RequestParam("code") String code,
                           @ModelAttribute PayloadDto dto) {
        final String token = authorizationService.getToken(code);
        dto.setAccessToken(token);
        return "index";
    }

}
