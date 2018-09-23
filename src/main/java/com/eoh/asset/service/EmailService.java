package com.eoh.asset.service;

public interface EmailService {

    public void sendSimpleEmail(String to, String subject, String text);
}
