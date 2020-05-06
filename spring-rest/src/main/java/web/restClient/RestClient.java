package web.restClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import web.model.User;

import java.util.List;

@Component
public class RestClient {
    private RestTemplate restTemplate = new RestTemplate();

    public User findUserByEmail(String email){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = mapper.writeValueAsString(email);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=");
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String>(json, headers);
            User user = restTemplate.exchange("http://localhost:8081/users/autorize", HttpMethod.POST, request, User.class).getBody();
            return user;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=");
        HttpEntity<String> request = new HttpEntity<String>(headers);
        try {
            return restTemplate.exchange("http://localhost:8081/users", HttpMethod.GET, request, new ParameterizedTypeReference<List<User>>(){}).getBody();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void addUser(User user) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = mapper.writeValueAsString(user);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=");
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String>(json, headers);
            restTemplate.exchange("http://localhost:8081/users", HttpMethod.POST, request, String.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = mapper.writeValueAsString(user);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=");
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String>(json, headers);
            restTemplate.exchange("http://localhost:8081/users", HttpMethod.PUT, request, String.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = mapper.writeValueAsString(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=");
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String>(json, headers);
            restTemplate.exchange("http://localhost:8081/users", HttpMethod.DELETE, request, String.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
