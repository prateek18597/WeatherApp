/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import org.apache.http.ssl.TrustStrategy;
/**
 *
 * @author SCEA
 */
public class Trust implements TrustStrategy {
/**
 * Implement strategy to always trust certificates.
 * @see {org.apache.http.ssl.TrustStrategy} TrustStrategy
 */
@Override
public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
    return true;
}

}