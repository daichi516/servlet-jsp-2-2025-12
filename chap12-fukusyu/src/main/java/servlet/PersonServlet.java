package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Person;

		
@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Personインスタンスの生成
		// Person インスタンスをリクエストスコープに保存
		// person.jspにフォワード
		
		List<Person> personList = new ArrayList<>();
		
		personList.add(new Person("浦島太郎", 42));
		personList.add(new Person("金太郎", 23));
		
		request.setAttribute("personList", personList);
		String url = "WEB-INF/jsp/person.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
