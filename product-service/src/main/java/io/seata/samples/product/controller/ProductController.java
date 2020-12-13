package io.seata.samples.product.controller;

import io.seata.samples.common.baseentity.StandResponse;
import io.seata.samples.common.exception.BusinessException;
import io.seata.samples.product.BaseController;
import io.seata.samples.product.entity.Product;
import io.seata.samples.product.req.AllocateInventoryReq;
import io.seata.samples.product.service.ProductService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品sku
 * @author scott lewis
 * @date 2019/05/27
 */
@RestController
@RequestMapping(value = "/v1/Product")
public class ProductController extends BaseController {

    @Resource
    private ProductService productService;

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author scott lewis
     * @date 2019/05/27
     **/
    @RequestMapping(value = "/load",method = RequestMethod.GET)
    public StandResponse<Product> load(Long sysno){
        return success(productService.load(sysno));
    }


    @RequestMapping(value = "/allocateInventory2",method = RequestMethod.POST)
    public StandResponse allocateInventory(@RequestBody List<AllocateInventoryReq> reqs) throws BusinessException {
        productService.allocateInventory(reqs);
        return success();
    }
}