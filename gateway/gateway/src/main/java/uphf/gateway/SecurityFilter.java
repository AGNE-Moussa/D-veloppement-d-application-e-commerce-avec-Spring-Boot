package uphf.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableReactiveMethodSecurity
@EnableWebFluxSecurity
public class SecurityFilter {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(authorize -> authorize
                        .pathMatchers(HttpMethod.GET, "/api/commandes/**")
                        .hasAuthority("SCOPE_read:commandes-service")
                        .pathMatchers(HttpMethod.GET, "/api/produits/**")
                        .hasAuthority("SCOPE_read:produits-service")
                        .anyExchange().authenticated())
                        .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtDecoder(jwtDecoder())));
        return http.build();
    }
    private ReactiveJwtDecoder jwtDecoder() {

        return new NimbusReactiveJwtDecoder("T8EpcbsO9ED7ze2gEG6HiAj5yiS_Bpsg4HFcGd_mCQ0BWgFLrpdfAeR-WSebanN9");
    }
}
