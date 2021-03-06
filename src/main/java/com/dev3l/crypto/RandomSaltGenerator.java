package com.dev3l.crypto;

import java.io.FileNotFoundException;
import java.security.SecureRandom;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.commons.codec.binary.Hex;

import com.dev3l.crypto.properties.CryptoPropertiesBean;
import com.dev3l.crypto.properties.CryptoPropertiesSingleton;

@ApplicationScoped
public class RandomSaltGenerator {
	@Inject
	public RandomSaltGenerator() {
	}

	public String createSalt() throws FileNotFoundException {
		final CryptoPropertiesBean cryptoPropertiesBean = CryptoPropertiesSingleton.getCryptoPropertiesBeanInstance();

		final byte[] saltBytes = new byte[cryptoPropertiesBean.getPbkdf2SaltByteSize()];
		new SecureRandom().nextBytes(saltBytes);

		return Hex.encodeHexString(saltBytes);
	}
}
