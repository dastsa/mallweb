package co.com.mallweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.com.mallweb.dao.Registro_DAO;

@WebServlet(name = "Loggin_srvlet", urlPatterns = {"/Loggin"})
public class Loggin_srvlet extends HttpServlet{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);  
        
        try {
        	String correo = request.getParameter("in_correoL");
 	        String contrasena = request.getParameter("in_contrasennaL");
 	        String message="";
 	        Registro_DAO rdarRegDAO= new Registro_DAO();
 	        
 	    	List<String> fields_select= new ArrayList<String>();
 	    	fields_select.add("cedula");
 	    	fields_select.add("nombre");
 	    	fields_select.add("apellidos");
 	    	fields_select.add("contrasenna");
 	    	fields_select.add("ciudad");
 	    	fields_select.add("direccion");
 	    	fields_select.add("codigopostal");
 	    	fields_select.add("monedero");
 	    	fields_select.add("celular");
 	    	fields_select.add("correo");
 	    	 	    	
 	    	Map<String, Object> fields_cond= new HashMap<String, Object>();
 	    	fields_cond.put("correo",correo);
 	    	fields_cond.put("contrasenna",contrasena);
 	    	
 	    	List<Map<String, Object>> ls= rdarRegDAO.get(fields_select, fields_cond);
 	    	
 	    	if(!ls.isEmpty()){
 	    		response.sendRedirect("oficina.jsp");
 	    		session.setAttribute("datos_usuario", ls.get(0));
 	    	}else{
 	    		response.sendRedirect("index.jsp?msg=Usuario o password incorrecto.");
 	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("index.jsp?msg=¡oh! ha ocurrido un error inesperado");
		}
       
	}
	
	 /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	processRequest(request, response);
        
    }

}
