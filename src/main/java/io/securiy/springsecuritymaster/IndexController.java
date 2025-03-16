package io.securiy.springsecuritymaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    SecurityContextService securityContextService;

    @GetMapping("/")
    public String index() {
        //현재 인증 상태를 받은 SecurityContext 가 넘어온다.
        SecurityContext securityContext = SecurityContextHolder.getContextHolderStrategy().getContext();
        // 이를 통해 Authentication 을 가지고 올 수 있다.
        Authentication authentication = securityContext.getAuthentication();
        System.out.println("authentication = " + authentication);

        securityContextService.securityContext();

        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping("/anonymous")
    public String anonymous() {
        return "anonymous";
    }

    @GetMapping("/authentication")
    public String authentication(Authentication authentication) {
        if(authentication instanceof AnonymousAuthenticationToken){
            return "anonymous";
        }else {
            return "not anonymous";
        }
    }

    @GetMapping("/anonymousContext")
    public String anonymousContext(@CurrentSecurityContext SecurityContext context) {
        return context.getAuthentication().getName();
    }

    @GetMapping("logoutSuccess")
    public String logoutSuccess() {
        return "logoutSuccess";
    }
}
