package com.cnbr.service.dao.transaction;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cnbr.service.domain.transaction.Registro;

@Component(value = RegistroDao.QUALIFIED_NAME)
public class RegistroDao {
	
	public static final String QUALIFIED_NAME = "RegistroDao";
	private static final String SQL_GET_REGISTRO = "com.cnbr.service.dao.transaction.RegistroDao.getRegistro";
	
	@Autowired
	@Qualifier(value = "sqlSessionTemplateCNBRDB")
	private SqlSessionTemplate sqlTemplate;
	
	public List<Registro> getRegistrosList(Registro query) {
		return sqlTemplate.selectList(SQL_GET_REGISTRO, query);
	}
	
}
