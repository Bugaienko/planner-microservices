package ua.bugaienko.micro.planner.users.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.bugaienko.micro.planner.entity.User;

/**
 * @author Sergii Bugaienko
 */


// принцип ООП: абстракция-реализация - здесь описываем все доступные способы доступа к данным
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);

    Page<User> findByUsernameContainingIgnoreCase(String username, Pageable pageable);
    Page<User> findByEmailContainsIgnoreCase(String email, Pageable pageable);

    void deleteByEmail(String email); // строгое соотвествие email (не вхождени)

    @Query("SELECT u FROM User u where " +
            "(:email is null or :email='' or lower(u.email) like lower(concat('%', :email,'%'))) or" +
            " (:username is null or :username='' or lower(u.username) like lower(concat('%', :username,'%')))"
    )

        // искать по всем переданным параметрам (пустые параметры учитываться не будут)
    Page<User> findByParams(@Param("email") String email,
                            @Param("username") String username,
                            Pageable pageable
    );

    Page<User> findByEmailContainsIgnoreCaseOrUsernameContainingIgnoreCase(
            @Param("email") String email,
            @Param("username") String username,
            Pageable pageable);
    Page<User> findByEmailContainsIgnoreCaseAndPasswordContainingIgnoreCase(
            @Param("email") String email,
            @Param("password") String password,
            Pageable pageable);

}
