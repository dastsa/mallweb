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
import co.com.mallweb.dao.Detalle_DAO;


@WebServlet(name = "CompraP_srvlet", urlPatterns = {"/CompraP"})
public class CompraP_srvlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);  
        
        try {
	        String nombre = request.getParameter("V_nombre");
	        String cantidad = request.getParameter("V_cantidad");
	        String id = request.getParameter("V_id");
	        int cant = Integer.parseInt(cantidad);
	        Producto_DAO producto= new Producto_DAO();
	        
	 	    	List<String> fields_select= new ArrayList<String>();
	 	    	fields_select.add("nombre");
	 	    	fields_select.add("precio");
	 	    	
	 	    	Map<String, Object> fields_cond= new HashMap<String, Object>();
	 	    	fields_cond.put("nombre",nombre);
	 	    	
	 	    	List<Map<String, Object>> ls= producto.get(fields_select, fields_cond);
	 	    	
	 	    	if(!ls.isEmpty()){
	 	    		Map<String, Object> row= ls.get(0);
	 	    		int precio = (Integer) row.get("precio");
	 	    		int subtotal = precio*cant;
	 	    		
	 	    		Detalle_DAO detalle= new Detalle_DAO();
	 	    		
	 	    		Map<String, Object> fields = new HashMap<String, Object>();
	 	    		fields.put("id_usuario", id);
	 		        fields.put("nombre", nombre);
	 		        fields.put("subtotal", subtotal);
	 		        
	 		        //fields.put("Control_Hash", Control_Hash);
	 				
	 		        int r=detalle.insert(fields);
	 	 	    	if(r>0){
	 	 	    		response.sendRedirect("expositorio.jsp"); 	    		
	 	 	    	}else{
	 	 	    		response.sendRedirect("expositorio.jsp?msg=Error al momento de Compra");
	 	 	    	}
	    		}
	        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
