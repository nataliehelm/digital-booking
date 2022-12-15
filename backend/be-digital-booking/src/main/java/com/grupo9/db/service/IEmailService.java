package com.grupo9.db.service;

import com.grupo9.db.model.EmailDetails;

public interface IEmailService {
    String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);
}
