package com.cnbr.service.business.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cnbr.service.dao.transaction.RegistroDao;
import com.cnbr.service.domain.transaction.Registro;

@Component
public class RegistroBusiness {

	@Autowired
	private RegistroDao registroDao;
	
	public List<Registro> getRegistroList(Registro query) {
		return registroDao.getRegistrosList(query);
	}
	
}
