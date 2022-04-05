package uz.pdp.instagram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.instagram.dto.ApiResponse;
import uz.pdp.instagram.dto.PostDto;
import uz.pdp.instagram.service.LikeService;

@RestController
@RequestMapping("/api/like")
@RequiredArgsConstructor
public class LikeController {
    final LikeService likeService;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PostDto postDto){
       ApiResponse apiResponse= likeService.add(postDto);
       return ResponseEntity.ok().body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
       ApiResponse apiResponse= likeService.delete(id);
       return ResponseEntity.ok().body(apiResponse);
    }


}
