package net.myphenotype.microservices.Player.Audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
//("AuditorAwareImpl") is optional here
@Component("AuditorAwareImpl")
public class AuditAwareImpl implements AuditorAware {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("Vijay");
    }
}
