package ems.servlets;

import java.io.IOException;





import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ems.dao.EmployeeDAO;
import ems.daoimpl.EmployeeDAOImpl;

/**
 * Servlet implementation class EmpolyeeServlet
 */
@WebServlet("/EmpolyeeServlet")
public class EmpolyeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpolyeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDAO emp = new EmployeeDAOImpl();
		
		if (request.getParameter("editid")!=null &&
				request.getParameter("ename")!="" &&
				request.getParameter("edept")!="" &&
				request.getParameter("edob")!="" &&
				request.getParameter("ename")!="" &&
				request.getParameter("egender")!="" &&
				request.getParameter("eemail")!="" &&
				request.getParameter("epass")!=""	
				){
			String ename=	request.getParameter("ename");
			String edept=	request.getParameter("edept");
			String edob=	request.getParameter("edob");
			String egender=	request.getParameter("egender");
			String eemail=	request.getParameter("eemail");
			String epass=	request.getParameter("epass");
			int editid=	Integer.parseInt(request.getParameter("editid"));
			emp.updateEmployee(editid, ename, edept, edob, egender, eemail, epass);
			response.sendRedirect("employee.jsp");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDAO emp = new EmployeeDAOImpl();
	
	if (request.getParameter("ename")!="" &&
		request.getParameter("edept")!="" &&
		request.getParameter("edob")!="" &&
		request.getParameter("ename")!="" &&
		request.getParameter("egender")!="" &&
		request.getParameter("eemail")!="" &&
		request.getParameter("epass")!="")
	{
	String ename=	request.getParameter("ename");
	String edept=	request.getParameter("edept");
	String edob=	request.getParameter("edob");
	String egender=	request.getParameter("egender");
	String eemail=	request.getParameter("eemail");
	String epass=	request.getParameter("epass");
	emp.addEmployee(ename, edept, edob, egender, eemail, epass);
	response.sendRedirect("employee.jsp");
	
	}
	else{
		response.sendRedirect("employee.jsp?status=error");
	}
	
		
	}

}
