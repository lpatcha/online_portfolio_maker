package com.portfolio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.RolesAndResponsibilites;

@Repository
public class RolesAndResponsibilitesImp implements RolesAndResponsibilitesDao{
	@Autowired
	RolesAndResponsibilitiesJpa rolesAndResponsibilitesJpa;
	
	
	@Override
	public RolesAndResponsibilites createRolesAndResponsibilites(RolesAndResponsibilites rolesAndResponsibilites) {
		// TODO Auto-generated method stub
		return rolesAndResponsibilitesJpa.save(rolesAndResponsibilites);
	}
	
}
