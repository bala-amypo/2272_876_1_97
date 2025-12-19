import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Certificate;
import com.example.demo.entity.VerificationLog;

public interface VerificationLogRepository extends JpaRepository<VerificationLog, Long> {
    List<VerificationLog> findByCertificate(Certificate certificate);
}
