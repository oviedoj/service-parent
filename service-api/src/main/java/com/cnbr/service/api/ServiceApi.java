package com.cnbr.service.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnbr.service.business.status.StatusBusiness;
import com.cnbr.service.domain.status.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Service
@Api( value = "ServiceApi")
@Path("com/cnbr/service/api/ServiceApi")
public class ServiceApi {

	@Autowired
	private StatusBusiness statusBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getStatusList")
	@ApiOperation("Get an status in String")
	public List<Status> getStatusList() {
		return statusBusiness.getStatusList();
	}
}
