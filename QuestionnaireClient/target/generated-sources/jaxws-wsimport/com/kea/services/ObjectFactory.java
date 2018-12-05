
package com.kea.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kea.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllQuestionnaires_QNAME = new QName("http://services.kea.com/", "getAllQuestionnaires");
    private final static QName _GetQuestionnaireResponse_QNAME = new QName("http://services.kea.com/", "getQuestionnaireResponse");
    private final static QName _GetAllQuestionnairesResponse_QNAME = new QName("http://services.kea.com/", "getAllQuestionnairesResponse");
    private final static QName _GetQuestionnaire_QNAME = new QName("http://services.kea.com/", "getQuestionnaire");
    private final static QName _SaveQuestionnaire_QNAME = new QName("http://services.kea.com/", "saveQuestionnaire");
    private final static QName _SaveQuestionnaireResponse_QNAME = new QName("http://services.kea.com/", "saveQuestionnaireResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kea.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveQuestionnaire }
     * 
     */
    public SaveQuestionnaire createSaveQuestionnaire() {
        return new SaveQuestionnaire();
    }

    /**
     * Create an instance of {@link SaveQuestionnaireResponse }
     * 
     */
    public SaveQuestionnaireResponse createSaveQuestionnaireResponse() {
        return new SaveQuestionnaireResponse();
    }

    /**
     * Create an instance of {@link GetAllQuestionnaires }
     * 
     */
    public GetAllQuestionnaires createGetAllQuestionnaires() {
        return new GetAllQuestionnaires();
    }

    /**
     * Create an instance of {@link GetQuestionnaireResponse }
     * 
     */
    public GetQuestionnaireResponse createGetQuestionnaireResponse() {
        return new GetQuestionnaireResponse();
    }

    /**
     * Create an instance of {@link GetAllQuestionnairesResponse }
     * 
     */
    public GetAllQuestionnairesResponse createGetAllQuestionnairesResponse() {
        return new GetAllQuestionnairesResponse();
    }

    /**
     * Create an instance of {@link GetQuestionnaire }
     * 
     */
    public GetQuestionnaire createGetQuestionnaire() {
        return new GetQuestionnaire();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllQuestionnaires }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.kea.com/", name = "getAllQuestionnaires")
    public JAXBElement<GetAllQuestionnaires> createGetAllQuestionnaires(GetAllQuestionnaires value) {
        return new JAXBElement<GetAllQuestionnaires>(_GetAllQuestionnaires_QNAME, GetAllQuestionnaires.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionnaireResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.kea.com/", name = "getQuestionnaireResponse")
    public JAXBElement<GetQuestionnaireResponse> createGetQuestionnaireResponse(GetQuestionnaireResponse value) {
        return new JAXBElement<GetQuestionnaireResponse>(_GetQuestionnaireResponse_QNAME, GetQuestionnaireResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllQuestionnairesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.kea.com/", name = "getAllQuestionnairesResponse")
    public JAXBElement<GetAllQuestionnairesResponse> createGetAllQuestionnairesResponse(GetAllQuestionnairesResponse value) {
        return new JAXBElement<GetAllQuestionnairesResponse>(_GetAllQuestionnairesResponse_QNAME, GetAllQuestionnairesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuestionnaire }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.kea.com/", name = "getQuestionnaire")
    public JAXBElement<GetQuestionnaire> createGetQuestionnaire(GetQuestionnaire value) {
        return new JAXBElement<GetQuestionnaire>(_GetQuestionnaire_QNAME, GetQuestionnaire.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveQuestionnaire }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.kea.com/", name = "saveQuestionnaire")
    public JAXBElement<SaveQuestionnaire> createSaveQuestionnaire(SaveQuestionnaire value) {
        return new JAXBElement<SaveQuestionnaire>(_SaveQuestionnaire_QNAME, SaveQuestionnaire.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveQuestionnaireResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.kea.com/", name = "saveQuestionnaireResponse")
    public JAXBElement<SaveQuestionnaireResponse> createSaveQuestionnaireResponse(SaveQuestionnaireResponse value) {
        return new JAXBElement<SaveQuestionnaireResponse>(_SaveQuestionnaireResponse_QNAME, SaveQuestionnaireResponse.class, null, value);
    }

}
