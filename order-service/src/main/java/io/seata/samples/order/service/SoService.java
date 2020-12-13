package io.seata.samples.order.service;

import io.seata.samples.common.exception.BusinessException;
import io.seata.samples.common.SnowflakeIdGenerator;
import io.seata.samples.order.dao.SoItemMapper;
import io.seata.samples.order.dao.SoMasterMapper;
import io.seata.samples.order.entity.SoItem;
import io.seata.samples.order.entity.SoMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoService {
    @Autowired
    SoMasterMapper soMasterMapper;

    @Autowired
    SoItemMapper soItemMapper;

    public List<Long> createSo(List<SoMaster> soMasters) throws BusinessException {
        List<Long> results = new ArrayList<>();
        if (soMasters.size()>0) {
            for (SoMaster soMaster : soMasters) {
                if (soMaster.getSoItems()!=null&&soMaster.getSoItems().size()>0) {
                    if (soMaster.getSysNo()==null) {
                        Long sysno = SnowflakeIdGenerator.getInstance().nextId();
                        soMaster.setSysNo(sysno);
                    }
                    soMaster.setStatus(10);
                    soMasterMapper.insert(soMaster);
                    for (SoItem soItem : soMaster.getSoItems()) {
                        soItemMapper.insert(soItem);
                    }
                    results.add(soMaster.getSysNo());
                }
            }
        }
        return results;
    }
}
