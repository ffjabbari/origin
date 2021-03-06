package parts.eip;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.0.1
 * 2015-03-06T09:53:59.903-07:00
 * Generated source version: 3.0.1
 * 
 */
@WebService(targetNamespace = "http://eip.parts", name = "PartsOrder")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface PartsOrder {

    @WebResult(name = "OrderResponse", targetNamespace = "http://eip.parts", partName = "OrderResponse")
    @WebMethod(operationName = "Order")
    public OrderResponse order(
        @WebParam(partName = "OrderRequest", name = "OrderRequest", targetNamespace = "http://eip.parts")
        OrderRequest orderRequest
    );
}
