package com.sohlman.liferayquery.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link QueryService}.
 *
 * @author Brian Wing Shun Chan
 * @see QueryService
 * @generated
 */
public class QueryServiceWrapper implements QueryService,
    ServiceWrapper<QueryService> {
    private QueryService _queryService;

    public QueryServiceWrapper(QueryService queryService) {
        _queryService = queryService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _queryService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _queryService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _queryService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<?> findBySQL(java.lang.String sql, int[] columns,
        java.lang.String[] columnNames)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _queryService.findBySQL(sql, columns, columnNames);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public QueryService getWrappedQueryService() {
        return _queryService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedQueryService(QueryService queryService) {
        _queryService = queryService;
    }

    @Override
    public QueryService getWrappedService() {
        return _queryService;
    }

    @Override
    public void setWrappedService(QueryService queryService) {
        _queryService = queryService;
    }
}
