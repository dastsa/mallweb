package co.com.mallweb;

/**
*
* HTMLMail.java
*
* clase para enviar correos HTML.
*
* @author Diego Duque Mora
* 
* TODO: enviar .css mediante CID, actualmente solo funciona si va incrustado en la pagina con <style></style>
*
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class HTMLMail {
	/**
	 * Algunas constantes
	 */
	static public int SIMPLE = 0;
	static public int MULTIPART = 1;
	/**
	 * Algunos mensajes de error
	 */
	public static String ERROR_01_LOADFILE = "Error al cargar el fichero";
	public static String ERROR_02_SENDMAIL = "Error al enviar el mail";
	/**
	 * Variables
	 */
	private Properties props = new Properties();
	private String user, password;
	private String from, content, to;
	private String subject = "";
	private String CCO = "";
	
	public String getCCO() {
		return CCO;
	}

	public void setCCO(String cco) {
		CCO = cco;
	}

	/**
	 * MultiPart para crear mensajes compuestos
	 */
	MimeMultipart multipart = new MimeMultipart("related");

	// -----
	/**
	 * Constructor
	 * 
	 * @param host
	 *            nombre del servidor de correo
	 * @param user
	 *            usuario de correo
	 * @param password
	 *            password del usuario
	 */
	public HTMLMail(String host, String user, String password) {
		this.user=user;
		this.password=password;
		ResourceBundle rb = ResourceBundle.getBundle("apro_config.mail");			
		String smtpPort =  rb.getString("smtpPort");
		
		props = new Properties();
		props.setProperty("mail.smtp.port", smtpPort);
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", host);
		props.setProperty("mail.smtp.auth", "true"); //Especifica que se requiere autentificaión
		
		//props.setProperty("mail.smtp.starttls.enable", "true");
	}

	// -----
	/**
	 * Muestra un mensaje de trazas
	 * 
	 * @param metodo
	 *            nombre del metodo
	 * @param mensaje
	 *            mensaje a mostrar
	 */
	static public void trazas(String metodo, String mensaje) {
		// TODO: reemplazar para usar Log4J
		//LOG_DEBUG.LogAPRO.log("", "[" + HTMLMail.class.getName() + "][" + metodo	+ "]:[" + mensaje + "]");
	}

	// -----
	/**
	 * Carga el contenido de un fichero de texto HTML en un String
	 * 
	 * @param pathname
	 *            ruta del fichero
	 * @return un String con el contenido del fichero
	 * @throws Exception
	 *             Excepcion levantada en caso de error
	 */
	static public String loadHTMLFile(String pathname) throws Exception {
		String content = "";
		File f = null;
		BufferedReader in = null;
		try {
			f = new File(pathname);
			if (f.exists()) {
				long len_bytes = f.length();
				//trazas("loadHTMLFile", "pathname:" + pathname + ", len:" + len_bytes);
			}
			in = new BufferedReader(new FileReader(f));
			String str;
			while ((str = in.readLine()) != null) {
				// process(str);
				str = str.trim();
				content = content + str;
			}
			in.close();
			return content;
		} catch (Exception e) {
			String MENSAJE_ERROR = ERROR_01_LOADFILE + ": ['" + pathname
					+ "'] : " + e.toString();
			throw new Exception(MENSAJE_ERROR);
		} finally {
			if (in != null)
				in.close();
		}
	}

	// ----
	/**
	 * Para probar el correcto funcionamiento de la clase
	 * 
	 * @param args
	 *            argumentos de entrada
	 * @throws Exception
	 *             excepcion levantada en caso de error
	 */
	public static void main(String[] args) throws Exception {
		try {
			// cargar en un string el template del HTML que se va a enviar
			String contenidoHTML = "<html><body><h1>Holaaaa</h1></body></html>"; //HTMLMail.loadHTMLFile("C:/cd/modelo_aprocom.htm");
			//LOG_DEBUG.LogAPRO.log("", "contenido HTML:" + contenidoHTML);
			// propiedades de conexion al servidor de correo
			//HTMLMail mail = new HTMLMail("smtp.aprocom.com.co", "cuentas@aprocom.com.co", "cuentas811");
			HTMLMail mail = new HTMLMail("webmail.exchange.telmexla.net.co", "cuentas@aprocom.com.co", "Cu3ntas_");
			mail.setFrom("diegoduque@aprocom.com.co");
			mail.setSubject("Prueba de HTML");
			mail.setTo("nelsonaugustoga@gmail.com");
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
			// para un correo SIMPLE seria:
			// mail.setContent(contenidoHTML);
			// mail.send();
			//LOG_DEBUG.LogAPRO.log("", "[ Mail enviado ]");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------
	/**
	 * Añade el contenido base al multipart
	 * 
	 * @throws Exception
	 *             Excepcion levantada en caso de error
	 */
	public void addContentToMultipart() throws Exception {
		// first part (the html)
		BodyPart messageBodyPart = new MimeBodyPart();
		String htmlText = this.getContent();
		messageBodyPart.setContent(htmlText, "text/html");
		// add it
		this.multipart.addBodyPart(messageBodyPart);
	}

	// -----
	/**
	 * Añade el contenido base al multipart
	 * 
	 * @param htmlText
	 *            contenido html que se muestra en el mensaje de correo
	 * @throws Exception
	 *             Excepcion levantada en caso de error
	 */
	public void addContent(String htmlText) throws Exception {
		// first part (the html)
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(htmlText, "text/html");
		// add it
		this.multipart.addBodyPart(messageBodyPart);
	}

	// -----
	/**
	 * Añade al mensaje un cid:name utilizado para guardar las imagenes
	 * referenciadas en el HTML de la forma <img src=cid:name />
	 * 
	 * @param cidname
	 *            identificador que se le da a la imagen. suele ser un string
	 *            generado aleatoriamente.
	 * @param pathname
	 *            ruta del fichero que almacena la imagen
	 * @throws Exception
	 *             excepcion levantada en caso de error
	 */
	public void addCID(String cidname, String pathname) throws Exception {
		DataSource fds = new FileDataSource(pathname);
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setDataHandler(new DataHandler(fds));
		messageBodyPart.setHeader("Content-ID", "<" + cidname + ">");
		this.multipart.addBodyPart(messageBodyPart);
	}

	// ----
	/**
	 * Añade un attachement al mensaje de email
	 * 
	 * @param pathname
	 *            ruta del fichero
	 * @throws Exception
	 *             excepcion levantada en caso de error
	 */
	public void addAttach(String pathname) throws Exception {
		File file = new File(pathname);
		BodyPart messageBodyPart = new MimeBodyPart();
		DataSource ds = new FileDataSource(file);
		messageBodyPart.setDataHandler(new DataHandler(ds));
		messageBodyPart.setFileName(file.getName());
		messageBodyPart.setDisposition(Part.ATTACHMENT);
		this.multipart.addBodyPart(messageBodyPart);
	}
	
	
	// ----
	/**
	 * Añade un attachements al mensaje de email desde una carpeta.
	 * 
	 * @param forder_name
	 *            ruta de la carpeta
	 * @param include_subfolders
	 *            se incluye las sub carpetas o no.
	 * @throws Exception
	 *             excepcion levantada en caso de error
	 */
	public void addAttachsFromFolder(String forder_name, boolean include_subfolders) throws Exception {
		File folder = new File(forder_name);
		
		if(folder!=null && folder.isDirectory()){
			File[] files= folder.listFiles();
			
			for (int i = 0; i < files.length; i++) {
				////LOG_DEBUG.LogAPRO.log("", "files[i].getPath(): " + files[i].getPath());				
				if(files[i].isFile()){
					if(!files[i].getName().endsWith(".html") && !files[i].getName().endsWith(".htm")){
						addAttach(files[i].getPath());
					}
				}else{
					addAttachsFromFolder(files[i].getPath(), include_subfolders);
				}
			}			
		}else{
			throw new Exception("La ruta de lacarpeta debe ser válida.");
		}
	}

	// ----
	/**
	 * Envia un correo multipart
	 * 
	 * @throws Exception
	 *             Excepcion levantada en caso de error
	 */
	public void sendMultipart() throws Exception {
		AprowebAutentificacionMail autApro = new AprowebAutentificacionMail();
		autApro.setAproUsr(user); //Especifica usuario
		autApro.setAproPsw(password); //Especifica password
		Authenticator auth = autApro;
		
		Session mailSession = Session.getInstance(this.props, auth);
		//mailSession.setDebug(true);
		Transport transport = mailSession.getTransport();
		MimeMessage message = new MimeMessage(mailSession);
		message.setSubject(this.getSubject());
		message.setFrom(new InternetAddress(this.getFrom()));
	
		StringTokenizer tokensMail = new StringTokenizer(this.getTo(),",");

		InternetAddress dests[] = new InternetAddress[tokensMail.countTokens()];
		int cont=0;
		while (tokensMail.hasMoreTokens()) {
			dests[cont]= new InternetAddress(tokensMail.nextToken());
			cont++;				
		}
	
		StringTokenizer tokensMailCCO = new StringTokenizer(this.getCCO(),",");
		InternetAddress destsCCO[] = new InternetAddress[tokensMailCCO.countTokens()];
		int contCCO=0;
		while (tokensMailCCO.hasMoreTokens()) {
			destsCCO[contCCO]= new InternetAddress(tokensMailCCO.nextToken());
			contCCO++;				
		}

		message.setRecipients(Message.RecipientType.TO, dests);
		message.setRecipients(Message.RecipientType.BCC, destsCCO);
		//	message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.getTo()));
		//	put everything together
		message.setContent(multipart);
		
		transport.connect();
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}
	// -----
	/**
	 * Envia un correo simple
	 * 
	 * @throws Exception
	 *             Excepcion levantada en caso de error
	 */
	public void send() throws Exception {
		try {
			AprowebAutentificacionMail autApro = new AprowebAutentificacionMail();
			autApro.setAproUsr(user); //Especifica usuario
			autApro.setAproPsw(password); //Especifica password
			Authenticator auth = autApro;
			   
			Session mailSession = Session.getInstance(this.props, auth);
			//mailSession.setDebug(true);
			Transport transport = mailSession.getTransport();
			MimeMessage message = new MimeMessage(mailSession);
			message.setSubject(this.getSubject());
			message.setFrom(new InternetAddress(this.getFrom()));
			message.setContent(this.getContent(), "text/html");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.getTo()));
			transport.connect();
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			transport.close();
		}catch (Exception e) {
			String MENSAJE_ERROR = ERROR_02_SENDMAIL + " : " + e.toString();
			throw new Exception(MENSAJE_ERROR);
		}
	}

	// -----
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
}
//end of class HTMLMail
