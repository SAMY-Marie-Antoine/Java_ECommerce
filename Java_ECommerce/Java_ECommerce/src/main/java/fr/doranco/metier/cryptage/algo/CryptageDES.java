package fr.doranco.metier.cryptage.algo;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import fr.doranco.enums.CryptageAlgorithm;




public final class CryptageDES {
	
	//méthode de cryptage
	   public final static byte[] encrypt(String messageToEncrypt, SecretKey key)throws Exception{
		
		// on choisit l'algorithme de cryptage
		Cipher cipher = Cipher.getInstance(CryptageAlgorithm.DES.toString());
		
		//on initialise le mode à appliquer (ici:cryptag)
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		//on transforme le message à crypter en bytes
		byte[] messageInByte=messageToEncrypt.getBytes("UTF-8");
		
		//on réalise l'opération de décryptage 
		byte[] messageEncrypte = cipher.doFinal(messageInByte);
		
		return messageEncrypte;
		}

	
	
	//méthode de décryptage
	public final static String decrypt(byte[] messageToDecrypt, SecretKey key) throws Exception {
		
		// on choisit l'algorithme de cryptage
		Cipher cipher = Cipher.getInstance(CryptageAlgorithm.DES.toString());
				
		//on initialise le mode à appliquer (ici:decryptag)
		cipher.init(Cipher.DECRYPT_MODE, key);
				
		
		//on réalise l'opération de décryptage 
		byte[] messageDecrypte = cipher.doFinal(messageToDecrypt);
		
		// On transforme le message décrypté en String
		String originalMessage = new String(messageDecrypte, "UTF-8");
				
				
		return originalMessage;
	}

	
	
}
