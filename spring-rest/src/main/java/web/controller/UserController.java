package web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.restClient.RestClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

@Controller
public class UserController {

    RestClient restClient;

    public UserController(RestClient restClient) {
        this.restClient = restClient;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String allUsers(ModelAndView modelAndView) {
        return "admin-page";
    }

    @RequestMapping("/login")
    public ModelAndView getLogin(Authentication authentication, HttpServletRequest request, ModelAndView model, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if (authentication != null) {
            boolean isAdmin = false;
            for (GrantedAuthority role : authentication.getAuthorities()) {
                if (role.getAuthority().equals("ADMIN")) {
                    isAdmin = true;
                };
            }
            if (isAdmin){
                httpServletResponse.sendRedirect("/admin");
            }else {
                httpServletResponse.sendRedirect("/user");
            }
        }

        if (request.getParameterMap().containsKey("error")) {
            model.setViewName("user-login");
            model.addObject("status", "Не верный Email или Password");
            return model;
        }
        model.setViewName("user-login");
        return model;
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView home(Authentication authentication, ModelAndView model) {
        model.addObject("user", restClient.findUserByEmail(authentication.getName()));
        model.setViewName("user-page");
        return model;
    }
}
