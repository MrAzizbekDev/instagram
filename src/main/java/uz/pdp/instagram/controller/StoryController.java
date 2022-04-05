package uz.pdp.instagram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.instagram.dto.ApiResponse;
import uz.pdp.instagram.dto.PostDto;
import uz.pdp.instagram.repository.StoryRepository;
import uz.pdp.instagram.service.PostService;
import uz.pdp.instagram.service.StoryService;

@RestController
@RequestMapping("/api/story")
@RequiredArgsConstructor
public class StoryController {

    final StoryService storyService;

    @GetMapping("/{userId}")
    public ResponseEntity getByUserId(@PathVariable Integer id) {
        ApiResponse apiResponse = storyService.getByUserId(id);
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PostDto postDto){
        ApiResponse apiResponse=storyService.add(postDto);
        return ResponseEntity.status(apiResponse.isSuccess()? 201:404).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        ApiResponse apiResponse=storyService.delete(id);
        return ResponseEntity.ok().body(apiResponse);
    }
}
