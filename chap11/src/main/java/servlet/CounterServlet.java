package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		Integer count = 0;
//		//アプリケーションスコープに保存したいからInteget型
//		ServletContext application = config.getServletContext();
//		application.setAttribute("count", count);
//		
//		System.out.println("init()が実行されました");
//	}

	public void destroy() {
		System.out.println("destroy()が実行されました");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		Integer count = (Integer) application.getAttribute("count");
		count++;
		application.setAttribute("count", count);
		String url ="WEB-INF/jsp/count.jsp";
		RequestDispatcher d = request.getRequestDispatcher(url);
		d.forward(request, response);
	}

}
