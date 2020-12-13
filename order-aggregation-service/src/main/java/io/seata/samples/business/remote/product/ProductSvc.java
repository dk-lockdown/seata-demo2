package io.seata.samples.business.remote.product;

import io.seata.samples.business.remote.product.entity.Product;
import io.seata.samples.business.remote.product.req.AllocateInventoryReq;
import io.seata.samples.common.baseentity.StandResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "product", url = "${product.svc.host}", path = "product")
public interface ProductSvc {
    /**
     * [查詢] 根據主鍵 id 查詢
     * @author scott lewis
     * @date 2019/05/27
     **/
    @RequestMapping(value ="/v1/Product/load",method = RequestMethod.GET)
    public StandResponse<Product> load(Long sysno);

    @RequestMapping(value ="/v1/Product/allocateInventory2",method = RequestMethod.POST)
    public StandResponse allocateInventory(@RequestBody List<AllocateInventoryReq> reqs);
}
