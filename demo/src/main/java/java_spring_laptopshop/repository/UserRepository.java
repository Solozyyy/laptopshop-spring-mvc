package java_spring_laptopshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java_spring_laptopshop.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User khoa);
}
