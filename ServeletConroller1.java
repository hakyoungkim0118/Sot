package util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServeletConroller
 */
@WebServlet(description = "ah....", urlPatterns = { "/empFind" })
public class ServeletConroller1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String btn = request.getParameter("button");  
		EmpRepo2 empSQL = new EmpRepo2();
		
		if(btn.equals("findAll")) {
			request.setAttribute("findall",empSQL.findAll());
			request.getRequestDispatcher("empList.jsp").forward(request, response);
		} else if (btn.equals("findByEmpno")) {
			request.setAttribute("findById",empSQL.findById(Integer.parseInt(request.getParameter("num"))));
			request.getRequestDispatcher("empList.jsp").forward(request, response);
		} else if(btn.equals("findByDept")) {
			request.setAttribute("findByDept",empSQL.findByDept(Integer.parseInt(request.getParameter("dept"))));
			request.getRequestDispatcher("empList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
