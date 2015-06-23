package com.redhat.samples.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.junit.Test;

public class CryptoFunsTest {

    @Test
    public void testGetHashDeclaracion() throws Exception {
	URL urlFile = CryptoFunsTest.class.getResource("/data.txt");

	assertNotNull("Data file exists", urlFile);

	String hash = CryptoFuns.getHashDeclaracion(urlFile.getFile());

	assertNotNull("Hash not null", hash);
	assertEquals("Hashes are equals", "E89543F99BB283D9B103153053EBAAD2", hash);
    }

    @Test
    public void testGetMD5Hash() throws Exception {
	URL urlFile = CryptoFunsTest.class.getResource("/data.txt");

	assertNotNull("Data file exists", urlFile);

	String cadenaEntrada = "";

	InputStreamReader fileReader = new InputStreamReader(CryptoFunsTest.class.getResourceAsStream("/data.txt"), Charset.forName("ISO-8859-1"));

	// Use this for reading the data.
	try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	    String line = null;
	    while ((line = bufferedReader.readLine()) != null) {
		cadenaEntrada += (line + "\r\n");
	    }
	} catch (IOException e) {
	    fail("Unable to read data file. Error: " + e.getMessage());
	}

	System.out.print("START DATA ************\n");
	System.out.print(cadenaEntrada);
	System.out.print("\nEND DATA   ************");

	// Hash
	String hashDefaultCharset = CryptoFuns.getMD5Hash(cadenaEntrada, null);

	assertNotNull("Hash not null", hashDefaultCharset);
	//assertEquals("Hashes are equals", "488BFF01C7BDB36DCEEBD98015BD9E5C", hashDefaultCharset);

	// Charset
	Charset windowsCharset = Charset.forName("UTF-8");

	// Hash
	String hashWindowsCharset = CryptoFuns.getMD5Hash(cadenaEntrada, windowsCharset);

	assertNotNull("Hash not null", hashWindowsCharset);
	//assertEquals("Hashes are equals", "60DAABA7E50D1F3A7C8A0F82ED2F0D50", hashWindowsCharset);
	
    }

}
