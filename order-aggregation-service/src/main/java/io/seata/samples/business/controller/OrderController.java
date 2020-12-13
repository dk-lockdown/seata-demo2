package io.seata.samples.business.controller;

import io.seata.samples.business.StandResponseBuilder;
import io.seata.samples.business.service.OrderService;
import io.seata.samples.common.baseentity.StandResponse;
import io.seata.samples.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/v1/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "create2", method = RequestMethod.GET)
    public @ResponseBody
    StandResponse<List<Long>> createSo2() throws BusinessException {
        return StandResponseBuilder.ok(orderService.createSo(true));
    }
}
