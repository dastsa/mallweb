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

import co.com.mallweb.dao.Registro_DAO;

@WebServlet(name = "Registro_srvlet", urlPatterns = {"/Registro"})
public class Registro_srvlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);  
        
        try {
	        String cedula= request.getParameter("in_cedula");
	        String nombres = request.getParameter("in_nombre");
	        String apellidos = request.getParameter("in_apellido");
	        String contrasena = request.getParameter("in_contrasenna");	        
	        String ciudad = request.getParameter("in_ciudad");
	        String codpostal = request.getParameter("in_postal");
	        String direccion = request.getParameter("in_direccion");
	        String email = request.getParameter("in_email");
	        String monedero = request.getParameter("in_monedero");
	        String numcel = request.getParameter("in_numcel");
	        //System.out.println("cedula: "+cedula);
	        //String Control_Hash=MD5.getMD5(cedula+contrasena+nombres+email+numcel);	
	        Registro_DAO RegDAO= new Registro_DAO();
	        
	        Map<String, Object> fields = new HashMap<String, Object>();
	        fields.put("cedula", cedula);
	        fields.put("nombre", nombres);
	        fields.put("apellidos", apellidos);
	        fields.put("contrasenna", contrasena);
	        fields.put("ciudad", ciudad);
	        fields.put("direccion", direccion);
	        fields.put("codigopostal", codpostal);
	        fields.put("monedero", monedero);
	        fields.put("celular", numcel);
	        fields.put("correo", email);
	        //fields.put("Control_Hash", Control_Hash);
			
	        int r=RegDAO.insert(fields);
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
       
        response.sendRedirect("login.jsp");
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
