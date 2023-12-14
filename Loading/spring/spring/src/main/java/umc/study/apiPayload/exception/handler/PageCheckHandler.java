package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.exception.GeneralException;

public class PageCheckHandler extends GeneralException {
    public PageCheckHandler(BaseErrorCode code) {
        super(code);
    }
}
