package io.seata.samples.product.service;

import io.seata.samples.common.exception.BusinessException;
import io.seata.samples.product.dao.InventoryMapper;
import io.seata.samples.product.dao.ProductMapper;
import io.seata.samples.product.entity.Product;
import io.seata.samples.product.req.AllocateInventoryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    InventoryMapper inventoryMapper;

    public Product load(Long sysno) {
        return productMapper.load(sysno);
    }

    public void allocateInventory(List<AllocateInventoryReq> reqs) throws BusinessException {
        for (AllocateInventoryReq req : reqs) {
            int result = inventoryMapper.allocateInventory(req.getProductSysNo(),req.getQty());
            if(result<=0) {
                throw new BusinessException("为订单分配库存失败");
            }
        }
    }
}
