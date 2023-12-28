package umc.study.service.StoreService;

import umc.study.converter.store.StoreConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

public interface StoreCommandService {
    Store joinStore(StoreRequestDTO.JoinDTO request);
    Store getStore(Long id);
    boolean isStore(Long id);
}
