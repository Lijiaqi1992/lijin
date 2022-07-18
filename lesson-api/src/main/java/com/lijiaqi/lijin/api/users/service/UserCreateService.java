package com.lijiaqi.lijin.api.users.service;

import com.lijiaqi.lijin.api.users.bo.LjUserBO;

public interface UserCreateService {
    LjUserBO createUser(LjUserBO userBO);

    LjUserBO createUserIfNotExistsInWx(LjUserBO userBO);

}
