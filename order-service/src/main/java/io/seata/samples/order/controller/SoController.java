package io.seata.samples.order.controller;

import io.seata.samples.common.baseentity.StandResponse;
import io.seata.samples.common.exception.BusinessException;
import io.seata.samples.order.entity.SoMaster;
import io.seata.samples.order.service.SoService;
import io.seata.samples.order.BaseController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单表
 * @author scott lewis
 * @date 2019/05/27
 */
@RestController
@RequestMapping(value = "/v1/So")
public class SoController extends BaseController {

    @Resource
    private SoService soService;

    @RequestMapping(value = "/insert2",method = RequestMethod.POST)
    public StandResponse<List<Long>> insert(@RequestBody List<SoMaster> soMasters) throws BusinessException {
        List<Long> result = soService.createSo(soMasters);
        return success(result);
    }
}