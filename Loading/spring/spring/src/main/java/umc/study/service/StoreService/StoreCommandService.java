package umc.study.service.StoreService;

import umc.study.converter.store.StoreConverter;
import umc.study.domain.Store;
import umc.study.web.dto.store.StoreRequestDTO;

public interface StoreCommandService {
    Store joinStore(StoreRequestDTO.JoinDTO request);
    //public Store getStore(Long id);
    Store getStore(Long id);
    boolean isStore(Long id);
}
