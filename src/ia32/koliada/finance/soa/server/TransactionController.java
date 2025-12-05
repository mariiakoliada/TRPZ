package ia32.koliada.finance.soa.server;

import ia32.koliada.finance.soa.dto.TransactionDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final Repository repo;
    private final SecurityService security;

    public TransactionController(Repository repo, SecurityService security) {
        this.repo = repo;
        this.security = security;
    }

    @PostMapping
    public String create(@RequestBody TransactionDTO dto) {
        dto.description = security.encrypt(dto.description);
        repo.save(dto);
        return "Saved Successfully";
    }

    @GetMapping
    public List<TransactionDTO> getAll() {
        List<TransactionDTO> list = repo.findAll();
        list.forEach(t -> t.description = security.decrypt(t.description));
        return list;
    }
}