

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditionalServlet
 */
@WebServlet("/AdditionalServlet")
public class AdditionalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String str1=request.getParameter("no1");
		String str2=request.getParameter("no2");
		String str3=request.getParameter("btn");
		int n1=Integer.parseInt(str1);
		int n2=Integer.parseInt(str2);
		String msg="";
		int ans=0;
		if(str3.equals("add")) {
			 ans=n1+n2;
			 msg="Addition";
		}
		if(str3.equals("sub")) {
			ans=n1-n2;
			msg="Substraction";
		}
		
		PrintWriter out=response.getWriter();
		out.print("<h1> Welcome to the servlet </h1>");
		out.println("<h1> Addition is "+ans+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
