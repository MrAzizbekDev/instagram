package uz.pdp.instagram.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

   private String caption;
   private  Integer userId;
   private Integer attachmentId;

   public PostDto(String caption) {
      this.caption = caption;
   }

   public PostDto(Integer userId, Integer attachmentId) {
      this.userId = userId;
      this.attachmentId = attachmentId;
   }
}
