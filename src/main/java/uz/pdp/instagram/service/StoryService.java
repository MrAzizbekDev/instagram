package uz.pdp.instagram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.instagram.dto.ApiResponse;
import uz.pdp.instagram.dto.PostDto;
import uz.pdp.instagram.entity.Attachment;
import uz.pdp.instagram.entity.Post;
import uz.pdp.instagram.entity.Story;
import uz.pdp.instagram.repository.AttachmentRepository;
import uz.pdp.instagram.repository.PostRepository;
import uz.pdp.instagram.repository.StoryRepository;
import uz.pdp.instagram.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class StoryService {
    final StoryRepository storyRepository;
    final AttachmentRepository attachmentRepository;
    final UserRepository userRepository;

    public ApiResponse getByUserId(Integer id) {
        List<Story> optional = storyRepository.getAllByUserId(id);
        return new ApiResponse("mana ", true,optional);
    }

    public ApiResponse add(PostDto postDto) {
        Story story = new Story();
        Optional<Attachment> repository = attachmentRepository.findById(postDto.getAttachmentId());
        if (!repository.isPresent()) return new ApiResponse("Attachment not found", false);
        story.setAttachment(repository.get());
        story.setUser(userRepository.getById(postDto.getUserId()));
        storyRepository.save(story);
        return new ApiResponse("saved", true);
    }

    public ApiResponse delete(Integer id) {
        storyRepository.deleteById(id);
        return new ApiResponse("deleted", true);
    }


}
