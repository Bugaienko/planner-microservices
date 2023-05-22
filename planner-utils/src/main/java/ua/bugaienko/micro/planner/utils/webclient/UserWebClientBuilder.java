package ua.bugaienko.micro.planner.utils.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ua.bugaienko.micro.planner.entity.User;

/**
 * @author Sergii Bugaienko
 */

@Component
public class UserWebClientBuilder {

    private static final String userBaseUrl = "http://localhost:8765/planner-users/user";
    private static final String userBaseData = "http://localhost:8765/planner-todo/data";

    public boolean isUserExists(Long userId) {
        try {
            User user = WebClient
                    .create(userBaseUrl)
                    .post()
                    .uri("/id")
                    .bodyValue(userId)
                    .retrieve()
                    .bodyToFlux(User.class)
                    .blockFirst();

            if (user != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public  Flux<User> isUserExistsAsync(Long userId) {


        Flux<User> userFlux = WebClient
                .create(userBaseUrl)
                .post()
                .uri("/id")
                .bodyValue(userId)
                .retrieve()
                .bodyToFlux(User.class);

        return userFlux;
    }

    public Flux<Boolean> initUserTestData(Long userId){
        return WebClient
                .create(userBaseUrl)
                .post()
                .uri("/init")
                .bodyValue(userId)
                .retrieve()
                .bodyToFlux(Boolean.class);
    }
}
