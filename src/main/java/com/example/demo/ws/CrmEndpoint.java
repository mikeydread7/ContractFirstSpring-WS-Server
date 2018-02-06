package com.example.demo.ws;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import org.example.crm.Customer;
import org.example.crm.GetCustomerByIdRequest;
import org.example.crm.GetCustomerByIdResponse;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.ws.Exception.ServiceFault;
import com.example.demo.ws.Exception.ServiceFaultException;
import com.example.demo.ws.domain.CompanyCustomer;
import com.example.demo.ws.service.CrmJpaService;
import com.example.demo.ws.service.CrmService;
import com.example.demo.ws.util.DateFormat;

@Endpoint
public class CrmEndpoint {

	private static final String NAMESPACE = "http://www.example.org/crm";
	private final static Logger LOG = LoggerFactory.getLogger(CrmEndpoint.class);
	private static final String NAMESPACE_URI = NAMESPACE;
	private CrmService crmService;
	private CrmJpaService crmJpaService;

	@Autowired
	public CrmEndpoint(CrmService crmService, CrmJpaService crmJpaService) {
		this.crmService = crmService;
		this.crmJpaService = crmJpaService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerByIdRequest")
	@ResponsePayload
	public GetCustomerByIdResponse findCustomerByIdRequestSpring_JAX_WS(@RequestPayload GetCustomerByIdRequest request,
			@RequestPayload Element incomming) {

		try {
			new XMLOutputter(Format.getPrettyFormat()).output(incomming, System.out);
		} catch (IOException e) {
			LOG.debug("{}", e.getMessage());
			throw new ServiceFaultException("ERROR",
					new ServiceFault("NOT_FOUND", "No Document " + request.getId() + " not found."));
		}

		Customer outgoing = new Customer();
		GetCustomerByIdResponse response = new GetCustomerByIdResponse();

		outgoing = this.crmService.findCustomerByIdRequest(request.getId());
		if (null == outgoing || null == outgoing.getCustomerId()) {
			outgoing = crmJpaService.findCustomerByIdRequest(request.getId());
		}
		response.setCustomer(outgoing);
		if (null == response.getCustomer().getCustomerId()) {
			StringBuffer strbf = new StringBuffer();
			strbf.append("Customer with id: ");
			strbf.append(request.getId());
			strbf.append(" not found.");
			throw new ServiceFaultException("ERROR", new ServiceFault("NOT_FOUND", strbf.toString()));
		}
		return response;
	}
}
