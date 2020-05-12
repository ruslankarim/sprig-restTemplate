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
            User user = restTemplate.getForEntity(URL + "user?email=" + email, User.class, request).getBody();
            return user;
    }

    public List<User> getAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", AUTH);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        return restTemplate.exchange(URL + "users", HttpMethod.GET, request, new ParameterizedTypeReference<List<User>>(){}).getBody();
    }

    public void addUser(User user) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = null;
        try {
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", AUTH);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(json, headers);
        restTemplate.postForEntity(URL + "users", request, String.class);
    }

    public void updateUser(User user) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = null;
        try {
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", AUTH);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(json, headers);
        restTemplate.put(URL + "users", request, String.class);
    }

    public void deleteUser(Long id) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", AUTH);
            HttpEntity<String> request = new HttpEntity<String>(headers);
            restTemplate.delete(URL + "users/" + id, request, String.class);
    }
}
