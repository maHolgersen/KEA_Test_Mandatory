
package com.kea.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "QuestionnaireService", targetNamespace = "http://services.kea.com/", wsdlLocation = "http://localhost:8080/QuestionaireWebService/QuestionnaireService?wsdl")
public class QuestionnaireService_Service
    extends Service
{

    private final static URL QUESTIONNAIRESERVICE_WSDL_LOCATION;
    private final static WebServiceException QUESTIONNAIRESERVICE_EXCEPTION;
    private final static QName QUESTIONNAIRESERVICE_QNAME = new QName("http://services.kea.com/", "QuestionnaireService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/QuestionaireWebService/QuestionnaireService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        QUESTIONNAIRESERVICE_WSDL_LOCATION = url;
        QUESTIONNAIRESERVICE_EXCEPTION = e;
    }

    public QuestionnaireService_Service() {
        super(__getWsdlLocation(), QUESTIONNAIRESERVICE_QNAME);
    }

    public QuestionnaireService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), QUESTIONNAIRESERVICE_QNAME, features);
    }

    public QuestionnaireService_Service(URL wsdlLocation) {
        super(wsdlLocation, QUESTIONNAIRESERVICE_QNAME);
    }

    public QuestionnaireService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, QUESTIONNAIRESERVICE_QNAME, features);
    }

    public QuestionnaireService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public QuestionnaireService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns QuestionnaireService
     */
    @WebEndpoint(name = "QuestionnaireServicePort")
    public QuestionnaireService getQuestionnaireServicePort() {
        return super.getPort(new QName("http://services.kea.com/", "QuestionnaireServicePort"), QuestionnaireService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns QuestionnaireService
     */
    @WebEndpoint(name = "QuestionnaireServicePort")
    public QuestionnaireService getQuestionnaireServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.kea.com/", "QuestionnaireServicePort"), QuestionnaireService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (QUESTIONNAIRESERVICE_EXCEPTION!= null) {
            throw QUESTIONNAIRESERVICE_EXCEPTION;
        }
        return QUESTIONNAIRESERVICE_WSDL_LOCATION;
    }

}
