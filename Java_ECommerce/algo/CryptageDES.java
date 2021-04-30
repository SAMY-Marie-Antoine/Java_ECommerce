package fr.doranco.metier.cryptage.algo;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import fr.doranco.enums.CryptageAlgorithm;




public final class CryptageDES {
	
	//m�thode de cryptage
	   public final static byte[] encrypt(String messageToEncrypt, SecretKey key)throws Exception{
		
		// on choisit l'algorithme de cryptage
		Cipher cipher = Cipher.getInstance(CryptageAlgorithm.DES.toString());
		
		//on initialise le mode � appliquer (ici:cryptag)
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		//on transforme le message � crypter en bytes
		byte[] messageInByte=messageToEncrypt.getBytes("UTF-8");
		
		//on r�alise l'op�ration de d�cryptage 
		byte[] messageEncrypte = cipher.doFinal(messageInByte);
		
		return messageEncrypte;
		}

	
	
	//m�thode de d�cryptage
	public final static String decrypt(byte[] messageToDecrypt, SecretKey key) throws Exception {
		
		// on choisit l'algorithme de cryptage
		Cipher cipher = Cipher.getInstance(CryptageAlgorithm.DES.toString());
				
		//on initialise le mode � appliquer (ici:decryptag)
		cipher.init(Cipher.DECRYPT_MODE, key);
				
		
		//on r�alise l'op�ration de d�cryptage 
		byte[] messageDecrypte = cipher.doFinal(messageToDecrypt);
		
		// On transforme le message d�crypt� en String
		String originalMessage = new String(messageDecrypte, "UTF-8");
				
				
		return originalMessage;
	}

	
	
}
