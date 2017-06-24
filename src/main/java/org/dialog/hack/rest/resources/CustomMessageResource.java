/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.rest.resources;

/**
 * @author Amila Karunathilaka
 * @since 17.07
 */
public class CustomMessageResource {

    private String message;


    public CustomMessageResource(String message) {
        this.message = message;
    }

    public CustomMessageResource(String message, String... args) {
        try {
            this.message = processMsg(message, args);
        } catch (Exception e) {
            this.message = e.getMessage();
        }
    }

    private String processMsg(String message, String... args) throws Exception {
        //todo need to optimize this
        int index = 0;
        while (message.contains("{}")) {
            message = message.replaceFirst("\\{\\}", args[index++]);
        }
        return message;
    }
}
