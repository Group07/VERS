package com.avers.Utils.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

/**
 * Created by Amila on 7/12/2015.
 */
public class LogWrapper {

    private Logger logger = null;
    private String prefix = "Audit Log";
    private String timeStampFormat = "yyyy/MM/dd HH:mm:ss";
    private String logFormat = "%s <(%s) %s> ";

    @SuppressWarnings("unchecked")
    public LogWrapper(Class clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }


    public void error(String message) {
        logger.error(formatLog(prefix, message));
    }

    public void error(String message, Throwable t) {
        logger.error(formatLog(prefix, message), t);
    }

    public void warn(String message) {
        logger.warn(formatLog(prefix, message));
    }

    public void warn(String message, Throwable t) {
        logger.warn(formatLog(prefix, message), t);
    }

    public void info(String message) {
        logger.info(formatLog(prefix, message));
    }

    public void info(String message, Throwable t) {
        logger.info(formatLog(prefix, message), t);
    }

    public void debug(String message) {
        logger.debug(formatLog(prefix, message));
    }

    public void debug(String message, Throwable t) {
        logger.debug(formatLog(prefix, message), t);
    }

    public void trace(String message, Throwable t) {
        logger.trace(formatLog(prefix, message), t);
    }

    public void trace(String message) {
        logger.trace(formatLog(prefix, message));
    }


    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();

    }

    private String getTimeStamp() {
        DateFormat dateFormat = new SimpleDateFormat(timeStampFormat);
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String formatLog(String prefix, String message) {
        String timeStamp = getTimeStamp();
        StringBuilder output = new StringBuilder();
        Formatter formatter = new Formatter(output);
        formatter.format(logFormat, prefix, timeStamp, message);
        return formatter.toString();
    }
}
