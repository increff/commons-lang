/*
 * Copyright (c) 2021. Increff
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

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
