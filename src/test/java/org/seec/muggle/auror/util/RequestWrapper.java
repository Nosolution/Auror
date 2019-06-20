package org.seec.muggle.auror.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

/**
 * 提供方法将body包装成{@link HttpEntity}类，少写重复代码
 *
 * @author Nosolution
 * @version 1.0
 * @since 2019/6/20
 */
public class RequestWrapper {

    private static final String customerToken = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyOCIsImV4cCI6MTU2MTY0ODUzNiwiaWF0IjoxNTYxMDQzNzM2fQ.a988qu3qJkJm7YrxdXEpVWbzJb0miZiMvEUyw6nDpm4VX40bN21WaK1KGf1H-rGR8EhvD966HREOF4qwSMebQQ";

    private static final String managerToken = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyNiIsImV4cCI6MTU2MTY0ODYyOCwiaWF0IjoxNTYxMDQzODI4fQ.yjhJXUgVaJlZAyKYoywjNRVfv-HZ05kTr2u6BlXDabX-1m4LP1lcu2CM7gMXBOqWrY8_2SYRasAbaLa2u_gp3Q";

    private static final String adminToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0IiwiZXhwIjoxNTYxNjQ4NjU2LCJpYXQiOjE1NjEwNDM4NTZ9.SPvpO0Sqmbo4N-4zwOcVCP4sOBUT2AR3GtvrZeoTLcGg5M659Io91vnMe-q-xG8R3isxi8pPlxyEdGIoNzCQKQ";

    public static HttpEntity of(Object body) {
        return new HttpEntity(body);
    }

    public static HttpEntity<?> withUserToken(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", customerToken);
        HttpEntity request = new HttpEntity(body, headers);
        return request;
    }

    public static HttpEntity withManagerToken(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", managerToken);
        HttpEntity request = new HttpEntity(body, headers);
        return request;
    }

    public static HttpEntity withAdminToken(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", adminToken);
        HttpEntity request = new HttpEntity(body, headers);
        return request;
    }


}
