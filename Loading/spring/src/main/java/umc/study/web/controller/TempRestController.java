package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResult;
import umc.study.converter.TempConverter;
import umc.study.service.TempService.TempQueryService;
import umc.study.web.dto.temp.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;
    @GetMapping("/test")
    public ApiResult<TempResponse.TempTestDTO> testAPI(){
        return ApiResult.onSuccess(TempConverter.toTempTestDTO());
    }
    @GetMapping("/exception")
    public ApiResult<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResult.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
