/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.tracnetreporting.service;

import java.util.List;

import org.hibernate.SQLQuery;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;

/**
 *
 */
public class ExecuteHibernateQueryLanguageUtil implements SettingSessionFactoryService {
	
	private static DbSessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(DbSessionFactory sessionFactory) {
		ExecuteHibernateQueryLanguageUtil.sessionFactory = sessionFactory;
	}
	
	/**
	 * @return the sessionFactory
	 */
	public static DbSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Object[]> executeHqlIndicators(String sqlQuery) {
		
		DbSession session = getSessionFactory().getCurrentSession();
		SQLQuery query = session.createSQLQuery(sqlQuery);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Integer> executeHqlPatients(String sqlQuery) {
		
		DbSession session = getSessionFactory().getCurrentSession();
		SQLQuery query = session.createSQLQuery(sqlQuery);
		
		return query.list();
	}
	
	/**
	 * @see org.openmrs.module.tracnetreporting.service.SettingSessionFactoryService#getStaticSessionFactory()
	 */
	@Override
	public DbSessionFactory getStaticSessionFactory() {
		
		return ExecuteHibernateQueryLanguageUtil.sessionFactory;
	}
}
