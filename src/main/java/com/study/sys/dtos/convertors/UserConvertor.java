package com.study.sys.dtos.convertors;

import com.study.sys.dtos.UserDto;
import com.study.sys.models.UserAccountModel;
import com.study.sys.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvertor {
    UserConvertor INSTANCE = Mappers.getMapper(UserConvertor.class);

    @Mappings({
        @Mapping(source="userModel.nickName", target="nickName"),
    })
    UserDto convert(UserAccountModel accountModel, UserModel userModel);
}
