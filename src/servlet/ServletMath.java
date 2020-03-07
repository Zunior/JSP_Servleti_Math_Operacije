package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletMath
 */
@WebServlet(
		urlPatterns = { "/ServletMath" }, 
		initParams = { 
				@WebInitParam(name = "a", value = "0"), 
				@WebInitParam(name = "b", value = "0"), 
				@WebInitParam(name = "c", value = "0"),
				@WebInitParam(name = "operacija", value = "")
		})
public class ServletMath extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMath() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = 0;
		int b = 0;
		int rezultat = 0;
		boolean dobar = true;
		
		HttpSession session = request.getSession();
		
		String errorMessageA = " ";
		String errorMessageB = " ";
		String operacija = "";
		String aString = request.getParameter("a");
		if(aString.isEmpty()) {
			errorMessageA = "Niste uneli prvi parametar";
			dobar = false;
		}else {
			try {
				a = Integer.parseInt(aString);
			}catch(Exception e) {
				errorMessageA = "Niste uneli broj";
				dobar = false;
			}
		}
		String bString = request.getParameter("b");
		if(bString.isEmpty()) {
			errorMessageB = "Niste uneli drugi parametar";
			dobar = false;
		}else {
			try {
				b = Integer.parseInt(bString);
			}catch(Exception e) {
				errorMessageB = "Niste uneli broj";
				dobar = false;
			}
		}
		request.setAttribute("messageA", errorMessageA);
		request.setAttribute("messageB", errorMessageB);
		session.setAttribute("a", a);
		session.setAttribute("b", b);
		
		if(dobar) {
			
			operacija = (String) request.getParameter("operacija");
			if(operacija.equals("plus")) {
				rezultat=a+b;
				session.setAttribute("rezultat", rezultat);
			}
			if(operacija.equals("minus")) {
				rezultat = a - b;
				session.setAttribute("rezultat", rezultat);
			}
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
