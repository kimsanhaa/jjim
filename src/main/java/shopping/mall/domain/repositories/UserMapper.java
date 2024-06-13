package shopping.mall.domain.repositories;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    Long findUserIdByEmail(String email);
}
