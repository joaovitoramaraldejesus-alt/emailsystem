package emailsystem.repository;

import emailsystem.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository
        extends JpaRepository<EmailEntity, Long> {
}