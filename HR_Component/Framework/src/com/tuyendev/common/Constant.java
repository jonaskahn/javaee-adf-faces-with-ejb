package com.tuyendev.common;

public class Constant {
    public final static String CURRENT_PAGE = "CURRENT_PAGE";
    public final static String SUB_MENU_ID = "SUB_MENU_ID";
    public final static String PROVIDER_URL = "t3://127.0.0.1:7101";

    public final static class SQL_OPERATOR {
        public final static String EQUAL = "EQUAL";
    }

    public final static class ACTION {
        public final static String ADD = "ADD";
        public final static String EDIT = "EDIT";
        public final static String DELETE = "DELETE";
    }

    public final static class TASK_FLOW_ACTION {
        public final static String ADD = "add";
        public final static String EDIT = "edit";
        public final static String VIEW = "view";
        public final static String DELETE = "delete";
        public final static String BACK = "back";
    }

    public final static class OBJECT_TASK_FLOW {
        public final static String EDIT_OBJECT = "EDIT_OBJECT";
        public final static String ADD_OBJECT = "ADD_OBJECT";
        public final static String DEL_OBJECT = "DEL_OBJECT";
        public final static String VIEW_OBJECT = "VIEW_OBJECT";
    }

    public final static class ERROR_CODE {
        public final static String VALIDATE = "VALIDATE";
        public final static String LOGIC = "LOGIC";
        public final static String RUNTIME = "RUNTIME";
        public final static String UNKNOWN = "UNKNOWN";
    }

    public final static class MAX_RESULT {
        public static final int MAX_100 = 100;
        public static final int MAX_200 = 200;
        public static final int MAX_500 = 500;
    }

    public final static class DEFAULT_TIMEOUT_MESSAGE {
        public final static long ERROR = 50000L;
        public final static long SUCCESS = 20000L;
        public final static long WARNING = 25000L;
        public final static long INFO = 10000L;
    }

    public final static class MENU {
        public final static String MENU_LINK = "https://jsonblob.com/api/jsonBlob/b59f11b4-9aad-11e7-aa97-e52e65d6fa23";
        public final static String SUB_MENU_LINK =
            "https://jsonblob.com/api/jsonBlob/8be6e001-9aae-11e7-aa97-352fcbee5937";
    }
}
