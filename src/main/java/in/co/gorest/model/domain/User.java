package in.co.gorest.model.domain;

import lombok.Data;

@Data
public class User {
    int id;
    String name;
    String email;
    String gender;
    String status;
    String token;
}
