package com.example.demo.ws.Exception;

/**
 * @see <a href="https://memorynotfound.com/spring-ws-add-detail-soapfault-exception-handling/"> howTo Example</a>
 * <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
 *   <SOAP-ENV:Header/>
 *    <SOAP-ENV:Body>
 *        <SOAP-ENV:Fault>
 *            <faultcode>SOAP-ENV:Server</faultcode>
 *            <faultstring>ERROR</faultstring>
 *            <detail>
 *                <code>NOT_FOUND</code>
 *                <description>some data issue.</description>
 *            </detail>
 *       </SOAP-ENV:Fault>
 *    </SOAP-ENV:Body>
 *</SOAP-ENV:Envelope>
 */

public class ServiceFaultException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private ServiceFault serviceFault;

    public ServiceFaultException(String message, ServiceFault serviceFault) {
        super(message);
        this.serviceFault = serviceFault;
    }

    public ServiceFaultException(String message, Throwable e, ServiceFault serviceFault) {
        super(message, e);
        this.serviceFault = serviceFault;
    }

    public ServiceFault getServiceFault() {
        return serviceFault;
    }

    public void setServiceFault(ServiceFault serviceFault) {
        this.serviceFault = serviceFault;
    }
}
