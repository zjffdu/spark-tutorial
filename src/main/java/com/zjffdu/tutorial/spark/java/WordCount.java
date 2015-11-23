package com.zjffdu.tutorial.spark.java;

import org.apache.commons.httpclient.HttpClient;

import javax.net.ssl.*;
import javax.security.cert.X509Certificate;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Created by jzhang on 9/8/15.
 */
public class WordCount {

  public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
/*
     *  fix for
     *    Exception in thread "main" javax.net.ssl.SSLHandshakeException:
     *       sun.security.validator.ValidatorException:
     *           PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException:
     *               unable to find valid certification path to requested target
     */
    TrustManager[] trustAllCerts = new TrustManager[] {
       new X509TrustManager() {
         @Override
         public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

         }

         @Override
         public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

         }

         public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
          }

          public void checkClientTrusted(X509Certificate[] certs, String authType) {  }

          public void checkServerTrusted(X509Certificate[] certs, String authType) {  }

       }
    };

    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, trustAllCerts, new java.security.SecureRandom());
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

    // Create all-trusting host name verifier
    HostnameVerifier allHostsValid = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
          return true;
        }
    };
    // Install the all-trusting host verifier
    HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    /*
     * end of the fix
     */

    URL url = new URL("https://www.csie.ntu.edu.tw");
    URLConnection con = url.openConnection();
    Reader reader = new InputStreamReader(con.getInputStream());
    while (true) {
      int ch = reader.read();
      if (ch==-1) {
        break;
      }
      System.out.print((char)ch);
    }
  }
}
