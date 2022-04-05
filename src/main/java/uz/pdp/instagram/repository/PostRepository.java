package uz.pdp.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.instagram.entity.Comment;
import uz.pdp.instagram.entity.Post;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Integer> {


 Optional<Post> findByUserId(Integer id);
}
