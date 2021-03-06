package uz.pdp.instagram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.instagram.dto.ApiResponse;
import uz.pdp.instagram.dto.RegisterDto;
import uz.pdp.instagram.service.UserService;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    final UserService userService;
    @PostMapping
    public ResponseEntity register(@RequestBody RegisterDto registerDto){
        ApiResponse apiResponse=userService.register(registerDto);
        return ResponseEntity.status(apiResponse.isSuccess()? 201:409).body(apiResponse);
    }
}
