package io.securiy.springsecuritymaster;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextService {
    public void securityContext() {
        //현재 인증 상태를 받은 SecurityContext 가 넘어온다.
        SecurityContext securityContext = SecurityContextHolder.getContextHolderStrategy().getContext();
        // 이를 통해 Authentication 을 가지고 올 수 있다.
        Authentication authentication = securityContext.getAuthentication();
        System.out.println("authentication = " + authentication);
    }
}
