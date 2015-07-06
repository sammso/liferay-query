package com.sohlman.liferayquery.service.impl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.sohlman.liferayquery.service.base.QueryServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The implementation of the query remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sohlman.liferayquery.service.QueryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sohlman.liferayquery.service.base.QueryServiceBaseImpl
 * @see com.sohlman.liferayquery.service.QueryServiceUtil
 */
public class QueryServiceImpl extends QueryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sohlman.liferayquery.service.QueryServiceUtil} to access the query
	 * remote service.
	 */
	public List<?> findBySQL(String sql, int[] columns, String[] columnNames)
			throws SystemException {

		// TODO: Add permission check

		userPersistence.openSession();

		Session session = null;

		if (columns == null) {
			columns = new int[] {};
		}
		if (columnNames == null) {
			columnNames = new String[] {};
		}

		try {
			//
			// Admit this is ugly hack, if you know better way for this please
			// end pull
			//
			session = userPersistence.openSession();

			SQLQuery q = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			List<?> result = (List<?>) q.list();

			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

			String format = null;

			for (Object obj : result) {
				Map<String, Object> map = new TreeMap<String, Object>();

				if (columns.length == 0) {
					if (obj instanceof Object[]) {
						Object[] values = (Object[]) obj;
						if (format == null) {
							int digits = (int) Math.log10(values.length) + 1;
							format = "column-%0" + digits + "d";
						}
						for (int i = 0; i < values.length; i++) {
							String name = String.format(format, i);

							if (i < columnNames.length) {
								name = columnNames[i];
							}
							map.put(name, values[i]);

						}
					}
					else {
						String name = "column";

						if (columnNames.length > 0) {
							name = columnNames[0];
						}
						map.put(name, obj);
					}
					list.add(map);
				} else {
					if (obj instanceof Object[]) {
						Object[] values = (Object[]) obj;
						if (format == null) {
							int digits = (int) Math.log10(columns.length) + 1;
							format = "column-%0" + digits + "d";
						}
						for (int i = 0; i < columns.length; i++) {
							int column = columns[i];

							String name = String.format(format, column);

							if (i < columnNames.length) {
								name = columnNames[i];
							}

							if (column < values.length) {
								map.put(name, values[column]);
							} else {
								map.put(name, null);
							}
						}
					}
					else {
						String name = "column";

						if (columnNames.length > 0) {
							name = columnNames[0];
						}
						map.put(name, obj);
					}
					list.add(map);
				}
			}

			return list;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			userPersistence.closeSession(session);
		}
	}
}
