package ia32.koliada.finance.soa.server;

import ia32.koliada.finance.soa.dto.AuthRequest;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final SecurityService securityService;

    public AuthController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest req) {
        if ("admin".equals(req.getUsername()) && "pass".equals(req.getPassword())) {
            return Collections.singletonMap("token", securityService.generateToken(req.getUsername()));
        }
        throw new RuntimeException("Invalid login");
    }
}