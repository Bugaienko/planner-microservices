package ua.bugaienko.micro.planner.users.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.bugaienko.micro.planner.entity.User;
import ua.bugaienko.micro.planner.users.repo.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author Sergii Bugaienko
 */

// всегда нужно создавать отдельный класс Service для доступа к данным, даже если кажется,
// что мало методов или это все можно реализовать сразу в контроллере
// Такой подход полезен для будущих доработок и правильной архитектуры (особенно, если работаете с транзакциями)


// все методы класса должны выполниться без ошибки, чтобы транзакция завершилась
// если в методе возникнет исключение - все выполненные операции откатятся (Rollback)
@Service
@Transactional
public class UserService {

    private final UserRepository repository; // сервис имеет право обращаться к репозиторию (БД)

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // возвращает только либо 0 либо 1 объект, т.к. email уникален для каждого пользователя
    public User findByEmail(String email) {
        return repository.findFirstByEmail(email);
    }

    public User add(User user) {
        return repository.save(user); // метод save обновляет или создает новый объект, если его не было
    }

    public User update(User user) {
        return repository.save(user); // метод save обновляет или создает новый объект, если его не было
    }

    public void deleteByUserId(Long id) {
        repository.deleteById(id);
    }

    public void deleteByUserEmail(String email) {
        repository.deleteByEmail(email);
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id); // т.к. возвращается Optional - можно получить объект методом get()
    }


    public Page<User> findByParams(String username, String password, PageRequest paging) {
        return repository.findByParams(username, password, paging);
    }

    public Page<User> findByUsernameOrPassword(String username, String password, PageRequest paging) {
        return repository.findByEmailContainsIgnoreCaseOrUsernameContainingIgnoreCase(username, password, paging);
    }

    public Page<User> findByUsernameOrEmail(String email, String username,  PageRequest paging) {
        if ((email == null || email.isEmpty()) && (username == null || username.isEmpty())) {
            return null;
        }

        if (email == null || email.isEmpty()) {
            return repository.findByUsernameContainingIgnoreCase(username, paging);
        }

        if (username == null || username.isEmpty()) {
            return repository.findByEmailContainsIgnoreCase(email, paging);
        }

        return repository.findByEmailContainsIgnoreCaseOrUsernameContainingIgnoreCase(email, username, paging);
    }


}
