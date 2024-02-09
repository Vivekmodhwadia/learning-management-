package com.vm189.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        return "home";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/securedPage")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public String index(Model model,
                        @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                        @AuthenticationPrincipal OAuth2User oauth2User, OAuth2AuthenticationToken token) {
        model.addAttribute("username", oauth2User.getName());
        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
        model.addAttribute("userAttributes", oauth2User.getAttributes());
        model.addAttribute("principal_given_name", token.getPrincipal().getAttributes().get("given_name"));
        return "securedPage";
    }

}
