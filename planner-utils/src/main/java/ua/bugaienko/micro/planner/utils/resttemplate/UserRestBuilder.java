package ua.bugaienko.micro.planner.utils.resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.bugaienko.micro.planner.entity.User;

/**
 * @author Sergii Bugaienko
 */

@Component
public class UserRestBuilder {
    private static final String userBaseUrl = "http://localhost:8765/planner-users/user";

    public boolean isUserExists(Long userId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Long> request = new HttpEntity<>(userId);

        ResponseEntity<User> response = null;

        try {
            response = restTemplate.exchange(userBaseUrl+ "/id", HttpMethod.POST, request, User.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
