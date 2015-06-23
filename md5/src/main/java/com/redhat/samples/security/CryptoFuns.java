package com.redhat.samples.security;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.redhat.samples.security.md5.MD5;

public class CryptoFuns {

    private CryptoFuns() {
	// Not instanciable
    }

    static final String CLAVE = "PRIVATE  KEY  FOR MD5 ";
    
    static final String CLAVE_FORMATED = "PRIVATE  KEY  FOR MD5                                           ";

    public static String getHashDeclaracion(String file) throws Exception {
	MD5 md5 = new MD5();
	md5.init();
        md5.digestFileToHexStr(new File(file), CLAVE_FORMATED);

        return md5.toHexString().toString().toUpperCase();
    }

    public static String getMD5Hash(String cadenaEntrada, Charset charset) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	String cadenaWithClave = CLAVE_FORMATED + cadenaEntrada;
	
	MessageDigest md = MessageDigest.getInstance("MD5");
	md.reset();
	if (null == charset) {
	    logBytes(cadenaWithClave.getBytes());
	    
	    md.update(cadenaWithClave.getBytes());
	} else {
	    logBytes(cadenaWithClave.getBytes(charset));
	    
	    md.update(cadenaWithClave.getBytes(charset));
	}
	byte[] digest = md.digest();
	return String.format("%032x", new BigInteger(1, digest)).toUpperCase();
    }
    
    private static void logBytes(byte[] arrBytes) {
	System.out.println("\nData(Bytes):");
	for (byte b : arrBytes) {
	    System.out.print("[" + b + "]");
	}
	System.out.println("");
    }

}
