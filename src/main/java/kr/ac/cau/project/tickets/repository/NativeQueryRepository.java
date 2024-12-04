package kr.ac.cau.project.tickets.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class NativeQueryRepository {
    private final EntityManager em;

    @Transactional
    public void processTransactionQueue() {
        em.createNativeQuery("call ProcessTransactionQueue();").executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public Optional<Long> login(String username, String password) {
        return em.createNativeQuery("CALL GetUserinfoByCredentials(:username, :password)", Long.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultStream().findFirst();
    }

    public void signin(String username, String password) {
        em.createNativeQuery("CALL InsertUserWithCredentials(:username, :password)")
                .setParameter("username", username)
                .setParameter("password", password)
                .executeUpdate();
    }
}