package ng.nectar.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;

public class LayoutController {

    @GetMapping("/")
    String index(Principal principal) {
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }

}
