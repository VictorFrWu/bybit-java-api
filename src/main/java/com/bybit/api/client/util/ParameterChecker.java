package com.bybit.api.client.util;

import com.bybit.api.client.exception.BybitApiException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

public final class ParameterChecker {

    private ParameterChecker() {
    }

    private static final int countStart = 0;
    private static final int countFinal = 1;

    public static void checkParameter(Map<String, Object> parameters, String parameter, Class<?> t) {
        checkRequiredParameter(parameters, parameter);
        checkParameterType(parameters.get(parameter), t, parameter);
    }

    public static void checkRequiredParameter(Map<String, Object> parameters, String parameter) {
        if (!parameters.containsKey(parameter)) {
            throw new BybitApiException(String.format("\"%s\" is a mandatory parameter!", parameter));
        }
    }

    public static void checkParameterType(Object parameter, Class<?> t, String name) {
        if (!t.isInstance(parameter)) {
            throw new BybitApiException(String.format("\"%s\" must be of %s type.", name, t));
        } else if (parameter instanceof String && ((String) parameter).isEmpty()) {
            throw new BybitApiException(String.format("\"%s\" must not be empty.", name));
        }
    }

    public static Object processId(Object id, String name) {
        if (!(id instanceof Integer || id instanceof String || id == null)) {
            throw new BybitApiException(name + " must be of Int or String type.");
        } else if (id == null || (id instanceof String && ((String) id).isEmpty())) {
            return UUID.randomUUID().toString();
        }
        return id;
    }

    public static void checkOnlyOneOfParameters(JSONObject params, String... parameters) {
        // checks if only one of the "parameters" is present at "params"
        if (params != null) {
            int count = countStart;
            for (String parameter : parameters) {
                if (params.has(parameter)) {
                    count++;
                }
            }
            if (count > countFinal) { // more than one parameter is present
                throw new BybitApiException("Only one of the following parameters is allowed: " + Arrays.toString(parameters));
            }
        }
    }

    public static void checkOneOfParametersRequired(JSONObject params, String... parameters) {
        // checks if at least one of the "parameters" is present at "params"
        String exceptMsg = "One of the following parameters is required: " + Arrays.toString(parameters);
        if (params != null) {
            int count = countStart;
            for (String parameter : parameters) {
                if (!params.has(parameter)) {
                    count++;
                }
            }
            if (count == parameters.length) { // none of the parameters is present
                throw new BybitApiException(exceptMsg);
            }
        } else {
            throw new BybitApiException(exceptMsg);
        }
    }
}
