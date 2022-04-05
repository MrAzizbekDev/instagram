package uz.pdp.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.instagram.entity.Comment;
import uz.pdp.instagram.entity.Story;

public interface StoryRepository extends JpaRepository<Story,Integer> {

}
