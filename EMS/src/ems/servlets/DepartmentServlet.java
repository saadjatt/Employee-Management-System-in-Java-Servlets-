package ems.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ems.dao.DepartmentDAO;
import ems.daoimpl.DepartmentDAOImpl;


/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DepartmentDAO dept;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
        dept= new DepartmentDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("editid")!=null &&
				request.getParameter("dname")!=""
		
				){
			String dname=	request.getParameter("dname");
			
			int editid=	Integer.parseInt(request.getParameter("editid"));
			dept.updateDepartment(editid, dname);
			response.sendRedirect("department.jsp");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("editid")!=null &&
				request.getParameter("dname")!=""
		
				){
			String dname=	request.getParameter("dname");
			
			//int editid=	Integer.parseInt(request.getParameter("editid"));
			dept.addDepartment(dname);
			response.sendRedirect("department.jsp");
		}
	}

}
