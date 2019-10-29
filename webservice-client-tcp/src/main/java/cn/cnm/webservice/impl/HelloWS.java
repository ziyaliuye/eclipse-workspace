
package cn.cnm.webservice.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import cn.cnm.webservice.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWS", targetNamespace = "http://webservice.cnm.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWS {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://webservice.cnm.cn/", className = "cn.cnm.webservice.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://webservice.cnm.cn/", className = "cn.cnm.webservice.SayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
