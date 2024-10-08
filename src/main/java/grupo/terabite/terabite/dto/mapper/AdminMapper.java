package grupo.terabite.terabite.dto.mapper;

import grupo.terabite.terabite.dto.create.AdminCreateDTO;
import grupo.terabite.terabite.entity.Admin;

public class AdminMapper {

    public static Admin of(AdminCreateDTO adminCreateDTO){
        if(adminCreateDTO == null) return null;

        return Admin.builder()
                .email(adminCreateDTO.getEmail())
                .senha(adminCreateDTO.getSenha())
                .build();
    }
}
