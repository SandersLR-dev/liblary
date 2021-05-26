package com.library.util;

import lombok.Getter;

@Getter
public class Constants {

    public static final int MAX_LOGIN_LENGTH = 20;
    public static final int MAX_NAME_LENGTH = 50;
    public static final int MAX_GENRE_LENGTH = 20;
    public static final int RECOMMENDED_PASSWORD_LENGTH = 10;

    public static final int ENCODER_SALT_LENGTH = 16;
    public static final int ENCODER_HASH_LENGTH = 32;
    public static final int ENCODER_PARALLELISM = 8;
    public static final int ENCODER_MEMORY = 524288;
    public static final int ENCODER_ITERATIONS = 8;

    public static final int BLOCKED_HOURS_COUNT = 12;
    public static final int CAPTCHA_HOUR_DURATION = 4;
    public static final int DEFAULT_ATTEMPT_COUNT = 1;
    public static final int MAX_FAILED_ATTEMPT_COUNT = 5;

    public static final int MILLIS_IN_SECOND = 1000;

    public static final int PAGE_SIZE = 20;

    public static final int DEFAULT_TRACK_COUNT = 0;
    public static final int DEFAULT_DURATION = 0;

    public static final String TIMEZONE = "UTC";
    public static final String DURATION_PATTERN = "%02d:%02d";

    public static final String CONTEXT_NAME = "Value";
    public static final String CONTEXT_FILE = "FileName";
    public static final String NAME_VALIDATOR_TYPE = "Name";

    public static final String ROLE_NAME = "authorities";

    public static final String CLIENT_IP_HEADER = "X-Forwarded-For";
    public static final String REGISTER_ACTION = "register";

    public static final String LOGIN_PAGE = "/signIn";
    public static final String LOGOUT_URL = "/logout";
    public static final String HOME_PAGE_URL = "/";

}

