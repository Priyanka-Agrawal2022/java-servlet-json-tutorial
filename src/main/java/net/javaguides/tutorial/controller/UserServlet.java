package net.javaguides.tutorial.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.javaguides.tutorial.model.User;
import net.javaguides.tutorial.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(urlPatterns = "/UserServlet", name = "UserServlet", description = "UserServlet return a JSON object")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = new ArrayList<>();
		users = service.getUsers();
		
		//convert java object "users" into a JSON object
		Gson gson = new Gson();
		String usersJSON = gson.toJson(users);
		
		//step1: set content type
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		//step2: get printWriter
		PrintWriter out = response.getWriter();
		
		//step3: generate content
		out.write(usersJSON);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
