/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.util;

/**
 * @author Amila Karunathilaka
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message, Object... args) {
        super((args.length > 0) ? ServiceException.generateMessage(message, args) : message);
    }

    public ServiceException(String message, Throwable cause, Object... args) {
        super((args.length > 0) ? ServiceException.generateMessage(message, args) : message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }


    private static String generateMessage(String message, Object... args) {
        int index = 0;
        while (message.contains("{}") && index < args.length) {
            message = message.replaceFirst("\\{\\}", String.valueOf(args[index++]));
        }
        return message;
    }

}
