package com.cnbr.service.business.status;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cnbr.service.domain.status.Status;
import com.cnbr.service.domain.utils.ObjectFactory;

@Component
public class StatusBusiness {
	
	public List<Status> getStatusList(){
		
		List<Status> list = new LinkedList<>();
		
		list.add(
		ObjectFactory.build(Status::new, s -> {
			s.setId(1);
			s.setInsertTs(LocalDateTime.now());
			s.setUpdateTs(LocalDateTime.now());
			s.setUpdateBy("jose");
			s.setInsertedBy("jose");
			s.setName("Test");
		}) );
		
		return list;
	}
	
}
