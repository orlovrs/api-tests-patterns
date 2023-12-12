package in.co.gorest.model.mappers;

import in.co.gorest.model.domain.User;
import in.co.gorest.model.dto.PostUsersRequestDto;
import org.modelmapper.ModelMapper;

public class UsersMapper {
    static ModelMapper mapper = new ModelMapper();

    static {
        mapper.typeMap(User.class, PostUsersRequestDto.class);
    }

    public static <T> T map(User user, Class<T> clazz) {
        return mapper.map(user, clazz);
    }
}
