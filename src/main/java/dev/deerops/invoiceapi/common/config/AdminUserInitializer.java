package dev.deerops.invoiceapi.common.config;

import dev.deerops.invoiceapi.user.model.entity.Role;
import dev.deerops.invoiceapi.user.model.entity.User;
import dev.deerops.invoiceapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Component
public class AdminUserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Value("${server.dev.password}")
    private String SERVER_DEV_PASSWORD;

    @Value("${server.dev.name}")
    private String SERVER_DEV_NAME;

    @Value("${server.dev.mail}")
    private String SERVER_DEV_MAIL;

    @Value("${server.dev.if.count}")
    private String SERVER_DEV_COUNT;

    public AdminUserInitializer(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == Integer.parseInt(SERVER_DEV_COUNT)) {

            String password = encoder.encode(SERVER_DEV_PASSWORD);

            User rootUser = new User();

            rootUser.setUsername(SERVER_DEV_NAME);
            rootUser.setPassword(password);
            rootUser.setRole(Collections.singletonList(Role.ADMIN));
            rootUser.setEmail(SERVER_DEV_MAIL);
            rootUser.setEnabled(true);
            rootUser.setCredentialsNonExpired(true);
            rootUser.setAccountNonLocked(true);
            rootUser.setAccountNonExpired(true);
            rootUser.setCreateAt(LocalDateTime.now());


            userRepository.save(rootUser);

        }
    }
}
