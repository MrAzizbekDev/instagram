package uz.pdp.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.instagram.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
   boolean existsByEmailOrPhone(String email, String phone);
   boolean existsByEmailAndPassword(String username,String password);
}
