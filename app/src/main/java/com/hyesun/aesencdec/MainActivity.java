package com.hyesun.aesencdec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //암호화 버튼 클릭
    public void doEncrypt(View v) throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        EditText editNormalString = (EditText) findViewById(R.id.editEncrypted);
        String normalString = editNormalString.getText().toString();

        AES256Cipher a256 = AES256Cipher.getInstance();
        String encryptedString = a256.AES_Encode(normalString);
        EditText editEncryptedResult = (EditText) findViewById(R.id.editEncryptedResult);
        editEncryptedResult.setText(encryptedString);

        String str="hyesun";
        String test = new String(Base64.encodeBase64(str.getBytes("UTF-8")));
        String zzz="";
    }

    //복호화 버튼 클릭
    public void doDecrypt(View v) throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        AES256Cipher a256 = AES256Cipher.getInstance();
        EditText editEncryptedResult = (EditText) findViewById(R.id.editEncryptedResult);
        String encryptedResult = editEncryptedResult.getText().toString();

        String normalString = a256.AES_Decode(encryptedResult);
        EditText editDecryptedResult = (EditText) findViewById(R.id.editDecryptedResult);
        editDecryptedResult.setText(normalString);

    }
}