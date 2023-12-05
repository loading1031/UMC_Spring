package umc.study.service.StoreService;

import umc.study.converter.store.StoreConverter;
import umc.study.domain.Store;
import umc.study.web.dto.store.StoreRequestDTO;

public interface StoreCommandService {
    public Store joinStore(StoreRequestDTO.JoinDTO request);
    //public Store getStore(Long id);
    public Store getStore(Long id);
    public boolean isStore(Long id);
}
