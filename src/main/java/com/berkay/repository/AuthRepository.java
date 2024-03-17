package com.berkay.repository;

import com.berkay.entity.Auth;
import static com.berkay.utility.Data.*;

public class AuthRepository {
    public void save(Auth entity){
        authList.add(entity);
}
}