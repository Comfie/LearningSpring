package zw.co.group.springlearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.group.springlearning.model.user;

@Repository
public interface usersRepository extends JpaRepository<user, Long> {

}
