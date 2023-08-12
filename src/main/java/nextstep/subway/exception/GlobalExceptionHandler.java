package nextstep.subway.exception;

import lombok.extern.slf4j.Slf4j;
import nextstep.common.StationBusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public void entityNotFoundExceptionHandler(EntityNotFoundException exception) {
        log.info("error occurred: {}", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(StationBusinessException.class)
    public void businessErrorExceptionHandler(RuntimeException exception) {
        log.info("error occurred: {}", exception.getMessage());
    }

}