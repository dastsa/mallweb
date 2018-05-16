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

import co.com.mallweb.dao.Producto_DAO;

@WebServlet(name = "Aprecio_srvlet", urlPatterns = {"/actualizarP"})
public class Aprecio_srvlet extends HttpServlet{
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);  
        try {
        	String nombre = request.getParameter("in_nombreA");
 	        String message="";
 	        Producto_DAO rdarRegDAO= new Producto_DAO();
 	        
 	    	List<String> fields_select= new ArrayList<String>();
 	    	fields_select.add("id_producto");
 	    	fields_select.add("nombre");
 	    	fields_select.add("imagen");
 	    	fields_select.add("precio");
 	    	fields_select.add("cantidad");
 	    	 	    	 	    	
 	    	Map<String, Object> fields_cond= new HashMap<String, Object>();
 	    	fields_cond.put("nombre",nombre);
 	    	
 	    	List<Map<String, Object>> ls= rdarRegDAO.get(fields_select, fields_cond);
 	    	
 	    	if(!ls.isEmpty()){
 	    		Map<String, Object> row= ls.get(0);
 	    		String nombreC = (String) row.get("nombre");
 	    		
 	    		String precio = request.getParameter("newprecio");
 	 	        
 	 	    	Map<String, Object> fields2 = new HashMap<String, Object>();
 	 	    
 	 	    	fields2.put("precio", precio);
 	 	    	
 				String sql_fields_cond="nombre=?";
 	 	    	
 				Map<Integer, Object> fields_cond_values= new HashMap<Integer, Object>();
 				fields_cond_values.put(1, nombreC);
 				
 				int r= rdarRegDAO.update(fields2 , sql_fields_cond, fields_cond_values);
 	 	    	
 	 	    	if(r>0){
 	 	    		response.sendRedirect("oficina.jsp?msg=Precio Actualizado"); 	    		
 	 	    	}else{
 	 	    		response.sendRedirect("index.jsp?msg=Error al momento de actualizar");
 	 	    	}
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
