package in.co.gorest.model.dto;

import lombok.Data;

@Data
public class PostUsersRequestDto {
    String name;
    String email;
    String gender;
    String status;
}