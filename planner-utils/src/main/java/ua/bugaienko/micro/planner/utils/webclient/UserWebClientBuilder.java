package ua.bugaienko.micro.planner.utils.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ua.bugaienko.micro.planner.entity.User;

/**
 * @author Sergii Bugaienko
 */

@Component
public class UserWebClientBuilder {

    private static final String userBaseUrl = "http://localhost:8765/planner-users/user";

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
}
