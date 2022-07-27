package com.ruoyi.framework.web.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Cbca;
import com.ruoyi.system.mapper.CbcaMapper;
import com.ruoyi.system.service.ISwJsCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class SwJsCustomerServiceImpl implements ISwJsCustomerService {

    @Resource
    private CbcaMapper cbcaMapper;
    @Override
    public String importSwJsCustomer(List<Cbca> swJsCustomersList, boolean updateSupport, String operName) {
        Long userid = SecurityUtils.getUserId();

        if (StringUtils.isNull(swJsCustomersList) || swJsCustomersList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (
                Cbca swJsCustomer : swJsCustomersList)
        {
            try
            {
                // 验证是否存在这个用户
                Cbca u = cbcaMapper.selectByPrimaryKey(swJsCustomer.getCbca01() );
                log.info(swJsCustomer.getCbca01()+"");
                if (StringUtils.isNull(u))
                {
                    swJsCustomer.setCbca08(swJsCustomer.getCbca08());
                    this.insertSwJsCustomer(swJsCustomer);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("客户信息列表").append(swJsCustomer.getCbca08()).append(" 导入成功");
                }
                else if (updateSupport)
                {
                    swJsCustomer.setCbca05(Math.toIntExact(userid));
                    this.updateSwJsCustomer(swJsCustomer);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("客户信息列表 ").append(swJsCustomer.getCbca08()).append(" 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("客户信息列表").append(swJsCustomer.getCbca08()).append(" 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "客户信息列表" + swJsCustomer.getCbca08() + " 导入失败：";
                failureMsg.append(msg).append(e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
    public int insertSwJsCustomer(Cbca cbca)
    {
        return cbcaMapper.insertCBCA(cbca);
    }
    public int updateSwJsCustomer(Cbca cbca)
    {
        return cbcaMapper.updateCBCA(cbca);
    }

}

