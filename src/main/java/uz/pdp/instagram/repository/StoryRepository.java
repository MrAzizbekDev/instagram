package uz.pdp.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.instagram.entity.Comment;
import uz.pdp.instagram.entity.Story;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story,Integer> {
   List<Story>getAllByUserId(Integer user_id);
}
