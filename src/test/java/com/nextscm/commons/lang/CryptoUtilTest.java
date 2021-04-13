package com.nextscm.commons.lang;

import org.junit.Test;
import java.security.GeneralSecurityException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CryptoUtilTest {

    @Test
    public void testEncrypt() throws GeneralSecurityException {
        String ciphertext = CryptoUtil.encrypt("Sample input plaintext", "sample key value");
        // Assumes AES encryption with ECB mode, 128 bit key size and Base64 output
        assertEquals("JI2w7aLDee9HWOxrxKGY067Jf0MzvUTnR2UbeJR7s4M=", ciphertext);
    }

    @Test
    public void testDecrypt() throws GeneralSecurityException {
        String plaintext = CryptoUtil.decrypt("JI2w7aLDee9HWOxrxKGY067Jf0MzvUTnR2UbeJR7s4M", "sample key value");
        assertEquals("Sample input plaintext", plaintext);
    }

}
