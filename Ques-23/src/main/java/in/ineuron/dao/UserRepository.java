package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
