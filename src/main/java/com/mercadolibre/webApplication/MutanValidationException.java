package com.mercadolibre.webApplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="No such Order")  // 403
public class MutanValidationException extends RuntimeException {
}