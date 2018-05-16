/*
 * Creado el 28/06/2006
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package co.com.mallweb;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author Diego Duque M
 *
 * Para cambiar la plantilla para este comentario de tipo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
public class AprowebAutentificacionMail extends Authenticator {
	private String aproUsr;
	private String aproPsw;
	
	  public PasswordAuthentication getPasswordAuthentication() {
		String username, password;
		username = aproUsr;
		password = aproPsw;
		////LOG_DEBUG.LogAPRO.log("", aproUsr +" ------------------------  "+aproPsw);
		return new PasswordAuthentication(username, password);
	  }

	/**
	 * @return
	 */
	public String getAproPsw() {
		return aproPsw;
	}

	/**
	 * @return
	 */
	public String getAproUsr() {
		return aproUsr;
	}

	/**
	 * @param string
	 */
	public void setAproPsw(String string) {
		aproPsw = string;
	}

	/**
	 * @param string
	 */
	public void setAproUsr(String string) {
		aproUsr = string;
	}

	
}
