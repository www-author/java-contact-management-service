package main.java.contact.management.constants;

public enum ExceptionMessage {

    BLANK_MENU_NUMBER("""
            
            메뉴 번호를 입력하세요.
            """),
    INVALID_MENU_NUMBER("""
            
            유효하지 않은 메뉴 번호입니다. 다시 입력해주세요.
            """),
    INVALID_CONTACT("""
            
            연락처가 올바르지 않습니다. 연락처 형식에 알맞게 입력해주세요.
            ( ex. 010-0000-0000 )
            """),
    EMPTY_VALUE("""
            
            빈 값을 입력할 수 없습니다. 다시 입력하세요.
            """),

    EMPTY_CONTACT("""
            
            연락처가 비어있습니다.
            """),

    NOT_FOUND_CONTACT("""
            
            연락처를 찾을 수 없습니다.
            """);

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
