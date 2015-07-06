package com.sohlman.liferayquery.service.base;

import com.sohlman.liferayquery.service.QueryServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QueryServiceClpInvoker {
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName18;
    private String[] _methodParameterTypes18;

    public QueryServiceClpInvoker() {
        _methodName14 = "getBeanIdentifier";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "setBeanIdentifier";

        _methodParameterTypes15 = new String[] { "java.lang.String" };

        _methodName18 = "findBySQL";

        _methodParameterTypes18 = new String[] {
                "java.lang.String", "int[][]", "java.lang.String[][]"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return QueryServiceUtil.getBeanIdentifier();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            QueryServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return QueryServiceUtil.findBySQL((java.lang.String) arguments[0],
                (int[]) arguments[1], (java.lang.String[]) arguments[2]);
        }

        throw new UnsupportedOperationException();
    }
}
