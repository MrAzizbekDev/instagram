package uz.pdp.instagram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.instagram.dto.ApiResponse;
import uz.pdp.instagram.dto.PostDto;
import uz.pdp.instagram.entity.Attachment;
import uz.pdp.instagram.entity.Like;
import uz.pdp.instagram.entity.Post;
import uz.pdp.instagram.repository.AttachmentRepository;
import uz.pdp.instagram.repository.LikeRepository;
import uz.pdp.instagram.repository.PostRepository;
import uz.pdp.instagram.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PostService {
    final PostRepository postRepository;
    final AttachmentRepository attachmentRepository;
    final UserRepository userRepository;
    final LikeRepository likeRepository;

    public ApiResponse getByUserId(Integer id) {
        Optional<Post> optional = postRepository.findByUserId(id);
        return new ApiResponse("mana ", true, optional.get());
    }

    public ApiResponse add(PostDto postDto) {
        Post post = new Post();
        Optional<Attachment> repository = attachmentRepository.findById(postDto.getAttachmentId());
        if (!repository.isPresent()) return new ApiResponse("Attachment not found", false);
        post.setAttachment(repository.get());
        post.setUser(userRepository.getById(postDto.getUserId()));
        post.setCaption(postDto.getCaption());
        postRepository.save(post);
        return new ApiResponse("saved", true);
    }

    public ApiResponse delete(Integer id) {
        postRepository.deleteById(id);
        return new ApiResponse("deleted", true);
    }

    public ApiResponse edit(PostDto postDto, Integer id) {
        Post post = postRepository.getById(id);
        post.setCaption(postDto.getCaption());
        postRepository.save(post);
        return new ApiResponse("edited",true);
    }

    public Integer addLike(Integer id) {
        Post post = postRepository.getById(id);
        List<Like> likeList = likeRepository.findByActiveTrue();
        post.setCountLike(likeList.size()+1);
        postRepository.save(post);
        return post.getCountLike();
    }
}
