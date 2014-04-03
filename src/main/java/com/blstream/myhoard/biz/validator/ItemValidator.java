package com.blstream.myhoard.biz.validator;

import com.blstream.myhoard.biz.enums.RequestMethodEnum;
import com.blstream.myhoard.biz.model.ItemDTO;
import com.blstream.myhoard.exception.MyHoardException;
import com.blstream.myhoard.exception.ValidatorException;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class ItemValidator extends AbstractValidator {

    private final String KEY_NAME = "name";

    public void validate(ItemDTO itemDTO, RequestMethodEnum requestMethod) throws MyHoardException {
        errorMessages = new HashMap<>();

        switch (requestMethod) {
            case POST:
            case PUT:
                validateItemDTO(itemDTO);
                break;
            default:
                break;
        }

        checkError();
    }

    private void validateItemDTO(ItemDTO itemDTO) throws MyHoardException {
        // name
        if (itemDTO.getName() != null) {
            itemDTO.setName(itemDTO.getName().trim());
        }
        if (itemDTO.getName() == null) {
            errorMessages.put(KEY_NAME, MESSAGE_NOT_EMPTY);
        } else if (itemDTO.getName().length() < 2 || itemDTO.getName().length() > 50) {
            errorMessages.put(KEY_NAME, String.format(MESSAGE_LENGTH_MIN_MAX, 2, 50));
        }
    }

    private void checkError() {
        if (!errorMessages.isEmpty()) {
            throw new ValidatorException(errorMessages);
        }
    }
}