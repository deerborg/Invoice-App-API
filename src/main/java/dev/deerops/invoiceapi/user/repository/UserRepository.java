package dev.deerops.invoiceapi.user.repository;

import dev.deerops.invoiceapi.user.model.entity.Role;
import dev.deerops.invoiceapi.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsernameOrEmail(String username,String email);
    List<User> findByRole(Role role);
}
