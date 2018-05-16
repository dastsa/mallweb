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

@WebServlet(name = "Link_srvlet", urlPatterns = {"/Link"})
public class Link_srvlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);  
        
        try {
        	String crhs =request.getParameter("crhs");

        	Registro_DAO rdarRegDAO= new Registro_DAO();

 	    	List<String> fields_select= new ArrayList<String>();
 	    	fields_select.add("Posicion");
 	    	fields_select.add("Nombres_Apellidos");
 	    	fields_select.add("Usuario");
 	    	fields_select.add("Habilitado");
 	    	fields_select.add("Clave");
 	    	fields_select.add("Nro_Celular");
 	    	fields_select.add("Correo_electronico");
 	    	 	    	
 	    	Map<String, Object> fields_cond= new HashMap<String, Object>();
 	    	fields_cond.put("Control_Hash",crhs);
 	    	
 	    	List<Map<String, Object>> ls= rdarRegDAO.get(fields_select, fields_cond);
 	    	
 	    	if(!ls.isEmpty()){
 	    		Map<String, Object> row= ls.get(0);
 	    		
 	    		if(((Integer)row.get("Habilitado"))==0) {
 	    			Map<String, Object> fields = new HashMap<String, Object>();
 	    	 	    
 	    	    	fields.put("Habilitado", 1);
 	    	    	
 	   			String sql_fields_cond="Posicion=?";
 	    	    	
 	   			Map<Integer, Object> fields_cond_values= new HashMap<Integer, Object>();
 	   			fields_cond_values.put(1, (Integer) row.get("Posicion"));
 	   			
 	   			int r= rdarRegDAO.update(fields , sql_fields_cond, fields_cond_values);
	 	   			if(r>0) {
	 	   				response.sendRedirect("index.jsp#loggin");
	 	   			}else {
	 	   				response.sendRedirect("index.jsp?msg=Error link verificacion");
	 	   			}
 	    		}
 	    	}else{
 	    		response.sendRedirect("index.jsp?msg=Error link verificacion");
 	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("index.jsp");
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
