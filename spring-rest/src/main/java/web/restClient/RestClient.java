package web.restClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final static String URL = "http://localhost:8081/api/";
    private final static String AUTH = "Basic YWRtaW46cGFzc3dvcmQ=";
    
    public User findUserByEmail(String email){
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", AUTH);
            HttpEntity<String> request = new HttpEntity<String>(headers);
            User user = restTemplate.exchange(URL + "user?email=" + email, HttpMethod.GET, request, User.class).getBody();
            return user;
    }

    public List<User> getAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", AUTH);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        try {
            return restTemplate.exchange(URL + "users", HttpMethod.GET, request, new ParameterizedTypeReference<List<User>>(){}).getBody();
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
            headers.add("Authorization", AUTH);
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String>(json, headers);
            restTemplate.exchange(URL + "users", HttpMethod.POST, request, String.class);
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
            headers.add("Authorization", AUTH);
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<String>(json, headers);
            restTemplate.exchange(URL + "users", HttpMethod.PUT, request, String.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Long id) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", AUTH);
            HttpEntity<String> request = new HttpEntity<String>(headers);
            restTemplate.exchange(URL + "users/" + id, HttpMethod.DELETE, request, String.class);
    }
}
