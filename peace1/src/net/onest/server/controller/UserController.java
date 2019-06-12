package net.onest.server.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.onest.server.entity.User;
import net.onest.server.service.UserService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	private Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS").create();
	
//	@RequestMapping("/addUser.json")
//	public void addUserFromClient(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("userName") String userName,@RequestParam("password") String password){
///*		String userName=request.getParameter("userName");
//		String password=request.getParameter("password");*/
//		User user = new User();
//		user.setUserName(userName);
//		user.setPassword(password);
//		
//		response.setContentType("application/json");
//		PrintWriter out = null;
//		JSONObject json = new JSONObject();
//		
//		try{
//			out = response.getWriter();
//			
//			if(userService.insertUser(user)==true){
//				json.put("status", 1);
//				out.write(json.toString());
//			}else{
//				json.put("status", 0);
//				out.write(json.toString());
//			}
//		} catch(Exception e){
//			e.printStackTrace();
//			json.put("status", -1);
//			out.write(json.toString());
//		}finally{
//			out.flush();
//			out.close();
//		}
//		
//	}
	
	@RequestMapping("/getInfo.json")
	public void getInfoFromClient(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("id") int id) {
		//int userId = Integer.parseInt(request.getParameter("id"));
		
		User user = new User();
		user.setUserId(id);

		response.setContentType("application/json");
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		
		try {	
			out = response.getWriter();
			
			user = userService.queryByID(user);
			if (user != null) {
				// user = testService.queryByID(user);
				//String empJson = gson.toJson(user);
				//model.addAttribute("result", empJson);
				json.put("status", 1);
				json.put("user", user);
				out.write(json.toString());
				// out.print(empJson);

			} else {
				//model.addAttribute("result", "null");				
				json.put("status", 0);
				json.put("user", null);
				out.write(json.toString());
				// out.print(empJson);

			}
		} catch (Exception e) {
			e.toString();
			json.put("status", -1);
			json.put("user", null);
			out.write(json.toString());
		} finally{
			out.flush();
			out.close();
		}

		//return "queryResult";
	}	
	
	@RequestMapping("/getUser.json")
	public void getUserFromClient(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("userPhone") String userPhone) {
		//int userId = Integer.parseInt(request.getParameter("id"));
		
		User user = new User();
		user.setUserPhone(userPhone);

		response.setContentType("application/json");
		PrintWriter out = null;
		JSONObject json = new JSONObject();
		
		try {	
			out = response.getWriter();
			
			user = userService.queryByPhone(user);
			if (user != null) {
				// user = testService.queryByID(user);
				//String empJson = gson.toJson(user);
				//model.addAttribute("result", empJson);
				json.put("status", 1);
				json.put("user", user);
				out.write(json.toString());
				// out.print(empJson);
			} else {
				//model.addAttribute("result", "null");				
				json.put("status", 0);
				json.put("user", null);
				out.write(json.toString());
				// out.print(empJson);

			}
		} catch (Exception e) {
			e.toString();
			json.put("status", -1);
			json.put("user", null);
			out.write(json.toString());
		} finally{
			out.flush();
			out.close();
		}

		//return "queryResult";
	}	
	
	@RequestMapping("getUsers")
	public ModelAndView getUsers() {
		ModelAndView mv = new ModelAndView("userList");
		List<User> users = userService.findAllUsers();
		mv.addObject("users", users);
		return mv;
	}
	
	@RequestMapping("addUser")
	public ModelAndView addUser() {
		ModelAndView mv = new ModelAndView("addUser");
		User u = new User();
		mv.addObject("user", u);
		return mv;
	}
	
	@RequestMapping("saveUser")
	public ModelAndView saveUser(User u) {
		userService.insertUser(u);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/user/getUsers");
		return mv;
	}
}
