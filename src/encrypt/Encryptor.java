package encrypt;

import java.math.BigInteger;
import java.util.Vector;

import key.PublicKey;

public class Encryptor {
	
	public static Vector<BigInteger> encrypt(String message, PublicKey pubk){
		Vector<BigInteger> crypted = new Vector<BigInteger>();
		BigInteger e = pubk.getPublicPair().e;
		BigInteger n = pubk.getPublicPair().n;
		for (int c=0; c<message.length(); c++){
			BigInteger bi = new BigInteger(Integer.toString(message.charAt(c)));
			crypted.add( bi.modPow(e, n) );
		}
		return crypted;
	}

}
