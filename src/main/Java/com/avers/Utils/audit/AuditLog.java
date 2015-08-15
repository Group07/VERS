package com.avers.Utils.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Amila on 8/15/2015.
 */
public class AuditLog {

    private Logger logger = null;

    @SuppressWarnings("unchecked")
    public AuditLog(Class clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }


    public void log(String message) {
        logger.warn(formatLog(message));
    }

    public String formatLog(String message) {
        String prefix = "Audit-Log";
        return prefix + ": " + message;
    }

}
