package jscode.backend.global.exception.domain;

import jscode.backend.global.exception.CustomException;
import jscode.backend.global.exception.ErrorInformation;

public class PostException extends CustomException {
    public PostException(ErrorInformation errorInformation) {
        super(errorInformation);
    }
}
