package tms.backend.controledeacesso.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

@Configuration
public class RoleHierarchyConfiguration {

    @Bean
    public RoleHierarchy roleHierarchyImpl() {
        RoleHierarchyImpl heararchy = new RoleHierarchyImpl();
        
        heararchy.setHierarchy("ADMIN > READ_USERS");

        return heararchy;
    }
}
