
package de.unikoblenz.sle;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "Wording", targetNamespace = "http://sle.unikoblenz.de/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Wording {


    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "count", targetNamespace = "http://sle.unikoblenz.de/", className = "de.unikoblenz.sle.Count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://sle.unikoblenz.de/", className = "de.unikoblenz.sle.CountResponse")
    public int count(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
