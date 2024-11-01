package be.pxl.services.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotificationRequest {

    private String source;
    private String destination;
    private String subject;
    private String message;
}
