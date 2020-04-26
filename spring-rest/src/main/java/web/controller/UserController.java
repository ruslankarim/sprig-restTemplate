package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Role;
import web.model.User;
import web.service.UserServiceImp;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*@Controller
@RequestMapping("/")*/
/*
public class UserController {

	@Autowired
	UserServiceImp userServiceImp;

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String userList(ModelMap model, Principal principal){

		User user = userServiceImp.findUserByEmail(principal.getName());
		boolean isAdmin = user.getRoles().stream().map(Role::getAuthority)
				.collect(Collectors.toList()).contains("ADMIN");
		List<User> users = userServiceImp.getAllUsers();
		model.addAttribute("user", user)
				.addAttribute("users", users)
				.addAttribute("isAdmin", isAdmin);
		return "admin-main";
	}

	@RequestMapping(value = "admin/new", method = RequestMethod.GET)
	public String newUserForm (ModelMap model, Principal principal){
		User user = userServiceImp.findUserByEmail(principal.getName());
		boolean isAdmin = user.getRoles().stream().map(Role::getAuthority)
				.collect(Collectors.toList()).contains("ADMIN");
		model.addAttribute("isAdmin", isAdmin)
				.addAttribute("user", user);
		return "admin-main-new-user";
	}

	//@RequestMapping(value = "admin/new", method = RequestMethod.POST)
	public String newUser (ModelMap model, Principal principal, HttpServletRequest request){
	    User user = new User();
	    user.setFirstName(request.getParameter("first_name"));
	    user.setLastName(request.getParameter("last_name"));
	    user.setAge(Integer.parseInt(request.getParameter("age")));
	    user.setEmail(request.getParameter("email"));
	    user.setPassword(request.getParameter("password"));
		Set<Role> roles = user.getRoles();
		if (request.getParameter("USER") != null) {
			roles.add(Role.USER);
		}
		if (request.getParameter("ADMIN") != null) {
			roles.add(Role.ADMIN);
		}
		user.setRoles(roles);
		userServiceImp.addUser(user);
		List<User> users = userServiceImp.getAllUsers();
		User currentUser = userServiceImp.findUserByEmail(principal.getName());
		boolean isAdmin = currentUser.getRoles().stream().map(Role::getAuthority)
				.collect(Collectors.toList()).contains("ADMIN");
		model.addAttribute("user", currentUser)
				.addAttribute("users", users)
				.addAttribute("isAdmin", isAdmin);
		return "redirect:/admin";
	}

	@RequestMapping(value = "admin/edit", method = RequestMethod.GET)
	public ResponseEntity<User> editUserForm(ModelMap model, Principal principal, HttpServletRequest request){
		User userEdit = userServiceImp.findUserByID(Long.parseLong(request.getParameter("id")));
		User currentUser = userServiceImp.findUserByEmail(principal.getName());
		boolean isAdmin = currentUser.getRoles().stream().map(Role::getAuthority)
				.collect(Collectors.toList()).contains("ADMIN");
		boolean isAdminEdit = userEdit.getRoles().stream().map(Role::getAuthority)
				.collect(Collectors.toList()).contains("ADMIN");
		model.addAttribute("isAdmin", isAdmin)
				.addAttribute("isAdminEdit", isAdminEdit)
				.addAttribute("userEdit", userEdit)
				.addAttribute("user", currentUser);
		return new ResponseEntity<User>(userEdit, HttpStatus.OK);
	}

	@RequestMapping(value = "admin/edit", method = RequestMethod.POST)
	public String editUser(ModelMap model, Principal principal, HttpServletRequest request){
	    User user = userServiceImp.findUserByID(Long.parseLong(request.getParameter("id")));
		Set<Role> roles = new HashSet<>();
		if (request.getParameter("USER") != null) {
			roles.add(Role.USER);
		}
		if (request.getParameter("ADMIN") != null) {
			roles.add(Role.ADMIN);
		}
        user.setFirstName(request.getParameter("first_name"));
        user.setLastName(request.getParameter("last_name"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
		user.setRoles(roles);
		userServiceImp.updateUser(user);
		List<User> users = userServiceImp.getAllUsers();
		User currentUser = userServiceImp.findUserByEmail(principal.getName());
		boolean isAdmin = currentUser.getRoles().stream().map(Role::getAuthority)
				.collect(Collectors.toList()).contains("ADMIN");
		model.addAttribute("user", currentUser)
				.addAttribute("users", users)
				.addAttribute("isAdmin", isAdmin);
		return "redirect:/admin";
	}

    @RequestMapping(value = "admin/delete", method = RequestMethod.GET)
    public String deleteUser(ModelMap model, Principal principal, HttpServletRequest request){
        User user = userServiceImp.findUserByID(Long.parseLong(request.getParameter("id")));
        userServiceImp.deleteUser(user);
        List<User> users = userServiceImp.getAllUsers();
        User currentUser = userServiceImp.findUserByEmail(principal.getName());
        boolean isAdmin = currentUser.getRoles().stream().map(Role::getAuthority)
                .collect(Collectors.toList()).contains("ADMIN");
        model.addAttribute("user", currentUser)
                .addAttribute("users", users)
                .addAttribute("isAdmin", isAdmin);
        return "redirect:/admin";
    }

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String userInfo(ModelMap model, Principal principal){
		User user = userServiceImp.findUserByEmail(principal.getName());
		boolean isAdmin = user.getRoles().stream().map(Role::getAuthority)
				.collect(Collectors.toList()).contains("ADMIN");
		model.addAttribute("user", user)
				.addAttribute("isAdmin", isAdmin);
		return "user-info";
	}

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String indexPage() {
		return "build/index";
	}

}*/
