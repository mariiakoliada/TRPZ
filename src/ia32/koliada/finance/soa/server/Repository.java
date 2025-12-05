package ia32.koliada.finance.soa.server;

import ia32.koliada.finance.soa.dto.TransactionDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {
    private final List<TransactionDTO> db = new ArrayList<>();

    public void save(TransactionDTO t) {
        db.add(t);
        System.out.println(">>> [DB] Saved: " + t.description);
    }

    public List<TransactionDTO> findAll() {
        return new ArrayList<>(db);
    }
}