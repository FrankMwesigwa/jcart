package com.jcart.modules.helpers;

import com.jcart.modules.tracker.batch.Batch;
import com.jcart.modules.tracker.batch.BatchDTO;
import com.jcart.modules.tracker.branch.BranchRepository;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    @Autowired
    private BranchRepository branchRepository;

    @SneakyThrows
    public <T> T convert(Object src, Class<T> destClass) {
        T dest = destClass.newInstance();
        BeanUtils.copyProperties(src,dest);
        return dest;
    }

    //public Batch asBatch(BatchDTO batchDTO) {
        //Batch batch = convert(batchDTO, Batch.class);
        //batch.setBranch(branchRepository.getOne(batchDTO.getBranchId()));
        //return batch;
    //}

    public Page<BatchDTO> asBatchDTOs(Page<Batch> page) {
        return page.map(batch -> Converter.this.convert(batch,BatchDTO.class));
    }
}
