package uz.pdp.instagram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.instagram.dto.ApiResponse;
import uz.pdp.instagram.dto.PostDto;
import uz.pdp.instagram.service.PostService;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    final PostService postService;


    @GetMapping("/{postId}")
    public ResponseEntity countLikeByPostId(@PathVariable Integer id){
        return ResponseEntity.ok().body(postService.addLike(id));
    }

    @GetMapping("/{userId}")
    public ResponseEntity getByUserId(@PathVariable Integer id) {
        ApiResponse apiResponse = postService.getByUserId(id);
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PostDto postDto){
        ApiResponse apiResponse=postService.add(postDto);
        return ResponseEntity.status(apiResponse.isSuccess()? 201:404).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        ApiResponse apiResponse=postService.delete(id);
        return ResponseEntity.ok().body(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody PostDto postDto,
                               @PathVariable Integer id){
        ApiResponse apiResponse=postService.edit(postDto,id);
        return ResponseEntity.ok().body(apiResponse);
    }


}
