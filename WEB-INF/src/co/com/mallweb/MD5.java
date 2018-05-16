package co.com.mallweb;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

 
public final class MD5 {
	public static void main(String args[]){
		try {
			//LOG_DEBUG.LogAPRO.log("", MD5.getMD5(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String convertToHex(byte[] data) throws Exception {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
        	int halfbyte = (data[i] >>> 4) & 0x0F;
        	int two_halfs = 0;
        	do {
	        	if ((0 <= halfbyte) && (halfbyte <= 9))	                
						buf.append((char) ('0' + halfbyte));					
	            else
	            		buf.append((char) ('a' + (halfbyte - 10)));					
	        	halfbyte = data[i] & 0x0F;
        	} while(two_halfs++ < 1);
        }
        return buf.toString();
    }
 
	public static String getMD5(String text) throws Exception  {
		MessageDigest md;
		md = MessageDigest.getInstance("MD5");
		byte[] md5hash = new byte[32];
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		md5hash = md.digest();
		return convertToHex(md5hash);
	}
	
	
	
	public static String getMD5File(String file) 
			throws NoSuchAlgorithmException,
				   UnsupportedEncodingException,
				   Exception
	{
		
		//Esta es otra forma

		MessageDigest digest = MessageDigest.getInstance("MD5");
		File f = new File(file);
		InputStream is = new FileInputStream(f);				
		byte[] buffer = new byte[8192];
		int read = 0;

		while( (read = is.read(buffer)) > 0) {
			digest.update(buffer, 0, read);
		}		
		byte[] md5sum = digest.digest();
		
		String output = convertToHex(md5sum);
		return output;		
		 		
		/*
		MessageDigest md;
		md = MessageDigest.getInstance("MD5");
		byte[] md5hash = new byte[32];
		
		File fileOrg = new File(file);
		
		FileInputStream fis = new FileInputStream(fileOrg);   

		byte[] buffer = new byte[(int)fileOrg.length()];   
		 
		fis.read(buffer,0,(int)fileOrg.length());    
		fis.close();	
		
		md.update(buffer, 0, buffer.length);
		md5hash = md.digest();
		buffer=null;		
		return convertToHex(md5hash);*/
	}
}