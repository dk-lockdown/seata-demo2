package io.seata.samples.business;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.common.util.StringUtils;
import io.seata.core.context.RootContext;
import org.apache.tomcat.util.collections.CaseInsensitiveKeyMap;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by duguk on 2018/1/5.
 */
@Component
public class RequestHeaderInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        /**
         * 获取不到springmvc请求上下文直接返回
         */
        if (attributes == null) {
            return;
        }

        String xid = RootContext.getXID();
        if (StringUtils.isNotBlank(xid)) {
            template.header(RootContext.KEY_XID.toLowerCase(), xid);
        }
    }
}
