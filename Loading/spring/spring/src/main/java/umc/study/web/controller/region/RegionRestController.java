package umc.study.web.controller.region;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.region.RegionConverter;
import umc.study.converter.store.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.service.RegionService.RegionCommandService;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.web.dto.region.RegionRequestDTO;
import umc.study.web.dto.region.RegionResponseDTO;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionRestController {
    private final RegionCommandService regionCommandService;
    @GetMapping("/stores")
    public ApiResponse<RegionResponseDTO.RegionResultDTO> show(@RequestBody @Valid RegionRequestDTO.RegionDTO request){

        Region region = regionCommandService.getRegion(request.getRegionId());
        return ApiResponse.onSuccess(RegionConverter.toRegionResultDTO(region));
    }
}
