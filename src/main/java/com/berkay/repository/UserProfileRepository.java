package com.berkay.repository;

import com.berkay.entity.UserProfile;

import java.util.Optional;

import static com.berkay.utility.Data.userList;


/**
 * 1- UserProfile nesnesi oluşturulurken ya da Auth nesnesi oluşturulurken
 * yani her hangi bir nesne oluşturulurken cteate ve update tarihlleri otomatik
 * atansın.
 * 2- Bir kayıt güncellendiğinde updateAt bilgisini de güncelleyin.
 */

public class UserProfileRepository {
    /**
     * 1- UserProfile nesnesi oluşturulurken, ya da Auth nesnesi oluşturulurken, yani herhangi bir
     * nesne oluşturulurken create ve update tarihleri oromatik atansın.
     * 2- Bir kayıt güncellendiğinde, updateAt bilgisini de güncelleyin.
     */

    long guncel = System.currentTimeMillis();

    public void save(UserProfile entity) {
        userList.add(entity);
    }

    public void update(UserProfile entity) {
        Optional<UserProfile> editUser = userList.stream().filter(x -> x.getId().equals(entity.getId())).findFirst();
        if (editUser.isEmpty())
            throw new RuntimeException("Kullanıcı Bulunamadı.");
        UserProfile edit = editUser.get();
        edit.setUpdateAt(System.currentTimeMillis());
        edit.setAd(entity.getAd());
        edit.setTelefon(entity.getTelefon());
    }

}