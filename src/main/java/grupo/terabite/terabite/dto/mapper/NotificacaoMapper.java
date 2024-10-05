package grupo.terabite.terabite.dto.mapper;

import grupo.terabite.terabite.dto.response.NotificacaoResponseDTO;
import grupo.terabite.terabite.entity.Notificacao;

public class NotificacaoMapper {

    public static NotificacaoResponseDTO toResponseNotificacaoDto(Notificacao notificacao){
        if(notificacao == null) return null;

        return NotificacaoResponseDTO.builder()
                .id(notificacao.getId())
                .email(notificacao.getEmail())
                .build();
    }
}
