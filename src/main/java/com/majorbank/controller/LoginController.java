package com.majorbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AndySun on 2016/10/6.
 */
@Controller
@RequestMapping("/api/login")
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    /**
     * Register Process:
     * 1) call /api/login/user [POST] to insert user data
     * 2) jump 'choose package page'
     *    a.Auto Recommand mode: /package/{jobId}/auto
     *    b.
     * 3)
     */

}
