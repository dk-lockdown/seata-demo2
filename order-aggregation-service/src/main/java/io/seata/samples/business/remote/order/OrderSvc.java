package io.seata.samples.business.remote.order;

import io.seata.samples.business.remote.order.entity.SoMaster;
import io.seata.samples.common.baseentity.StandResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "order", url = "${order.svc.host}", path = "order")
public interface OrderSvc {

    @RequestMapping(value = "/v1/So/insert2",method = RequestMethod.POST)
    public StandResponse<List<Long>> insert(@RequestBody List<SoMaster> soMasters);
}
