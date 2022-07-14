package com.lijiaqi.lijin.service.impl.user;

import com.lijiaqi.lijin.api.users.bo.UserBO;
import com.lijiaqi.lijin.api.users.service.LoginService;
import com.lijiaqi.lijin.dao.UserPOMapper;
import com.lijiaqi.lijin.po.UserPO;
import com.lijiaqi.lijin.po.UserPOCriterion;
import com.ljq.plugins.base.exception.MyBusinessException;
import com.ljq.plugins.base.security.jwt.LjqJwt;
import com.ljq.plugins.base.util.GzipUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @描述： 用户登录
 * @作者： 李佳琪
 * @时间 2022-01-09
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UserPOMapper userPOMapper;

    @Override
    public String login(UserBO userBO) {

        UserPOCriterion userPOCriterion = new UserPOCriterion();
        UserPOCriterion.Criteria criteria = userPOCriterion.createCriteria();
        criteria.andUserNameEqualTo(userBO.getUserName());

        List<UserPO> userPOS = userPOMapper.selectByExample(userPOCriterion);
        if (userPOS.size() != 1) {
            throw new MyBusinessException("用户名不正确！");
        }

        UserPO userPO = userPOS.get(0);

        if(!StringUtils.equals(userPO.getStatus(), "0")){
            throw new MyBusinessException("用户状态异常！");
        }

        //判断密码
        //明文密码 + 逆序盐 + 盐
        String str = String.format("%s_%s_%s", userBO.getPassword(), new StringBuilder(userPO.getSalt()).reverse().toString(), userPO.getSalt());
        String pwd = GzipUtil.bytesToHexString(GzipUtil.gZip(str.getBytes()));
        if(!StringUtils.equals(pwd, userPO.getPassword())){
            throw new MyBusinessException("密码不正确！");
        }
        return LjqJwt.generateToken(userPO.getUserId(), userPO.getUserName());
    }
}
