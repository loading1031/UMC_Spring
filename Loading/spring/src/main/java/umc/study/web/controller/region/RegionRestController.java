package umc.study.web.controller.region;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResult;
import umc.study.converter.region.RegionConverter;
import umc.study.domain.Region;
import umc.study.service.RegionService.RegionCommandService;
import umc.study.web.dto.region.RegionRequestDTO;
import umc.study.web.dto.region.RegionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionRestController {
    private final RegionCommandService regionCommandService;
    @GetMapping("/stores")
    public ApiResult<RegionResponseDTO.RegionResultDTO> show(@RequestBody @Valid RegionRequestDTO.RegionDTO request){

        Region region = regionCommandService.getRegion(request.getRegionId());
        return ApiResult.onSuccess(RegionConverter.toRegionResultDTO(region));
    }
}
