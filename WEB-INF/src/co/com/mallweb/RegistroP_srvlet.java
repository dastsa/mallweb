package co.com.mallweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.com.mallweb.dao.RegistroP_DAO;

@WebServlet(name = "RegistroP_srvlet", urlPatterns = {"/Rproducto"})
public class RegistroP_srvlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);  
        
        try {
	        String id= request.getParameter("P_id");
	        String nombre = request.getParameter("P_nombre");
	        String imagen = request.getParameter("P_imagen");
	        String precio = request.getParameter("P_precio");	        
	        String cantidad = request.getParameter("P_cantidad");
	        System.out.println("precio: "+precio);
	        //String Control_Hash=MD5.getMD5(cedula+contrasena+nombres+email+numcel);	
	        RegistroP_DAO RegDAO= new RegistroP_DAO();
	        
	        Map<String, Object> fields = new HashMap<String, Object>();
	        fields.put("id_producto", id);
	        fields.put("nombre", nombre);
	        fields.put("imagen", imagen);
	        fields.put("precio", precio);
	        fields.put("cantidad", cantidad);
	        //fields.put("Control_Hash", Control_Hash);
			
	        int r=RegDAO.insert(fields);
	        response.sendRedirect("oficina.jsp?msg=Producto Registrado.");
	        /*if(r>0){
	        	String contenidoHTML = HTMLMail.loadHTMLFile(request.getServletContext().getRealPath("/")+"plantillaCorreo.html");
	        	contenidoHTML= contenidoHTML.replaceAll("<HASH_CONTROL>", Control_Hash);
				//LOG_DEBUG.LogAPRO.log("", "contenido HTML:" + contenidoHTML);
				// propiedades de conexion al servidor de correo
				//HTMLMail mail = new HTMLMail("smtp.aprocom.com.co", "cuentas@aprocom.com.co", "cuentas811");
				HTMLMail mail = new HTMLMail("webmail.exchange.telmexla.net.co", "cuentas@aprocom.com.co", "Cu3ntas_");
				mail.setFrom("cuentas@aprocom.com.co");
				mail.setSubject("Link de Activaciòn");
				mail.setTo(email);
				// fijar el contenido
				mail.addContent(contenidoHTML);
				// CID de una imagen
				//mail.addCID("cidimage01", "/home/jose/firma.gif");
				// enviar atachados un par de ficheros
				//mail.addAttach("C:/cd/modelo_aprocom_archivos/image001.png");
				//mail.addAttach("C:/cd/modelo_aprocom_archivos/image002.jpg");
				// mail.addAttach("/home/jose/bison_1_0.zip");
				// enviar el correo MULTIPART
				mail.sendMultipart();

	        }else {}*/
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
