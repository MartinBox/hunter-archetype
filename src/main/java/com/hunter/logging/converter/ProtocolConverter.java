package com.hunter.logging.converter;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class ProtocolConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        String t = event.getThreadName();
        if (t == null) {
            return null;
        }
        if (t.length() > 5) {
            return Character.isLetter(t.charAt(4)) ? t.toUpperCase() : t.substring(0, 4).toUpperCase();
        }
        return t;
    }
}
