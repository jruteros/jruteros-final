package clasesUtiles;

import java.security.MessageDigest;

public class Sha256 {
	
	public Sha256(){}
	
	public String getSha256(String st) {
		try{
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			sha256.update(st.getBytes("UTF-8"));
			byte[] digest = sha256.digest();
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<digest.length;i++){
			    sb.append(String.format("%02x", digest[i]));
			}
			return sb.toString();
		}catch (Exception e) {
			return null;
		}
	}

}
