package main.java.contact.management.constants;

public enum Message {
    CONTACT_MENU_SELECT("""
            1. 비즈니스 연락처 추가
            2. 개인 연락처 추가
            3. 연락처 출력
            4. 연락처 검색
            5. 종료
            메뉴를 선택해주세요:%1s"""
            .formatted("")
    ),
    INPUT_NAME("이름을 입력하세요: "),
    INPUT_CONTACT("전화번호를 입력하세요: "),
    INPUT_COMPANY_NAME("회사명을 입력하세요: "),
    INPUT_RELATIONSHIP("관계를 입력하세요: "),
    INPUT_NAME_TO_SEARCH("검색할 이름을 입력하세요: "),
    EXIT_THE_PROGRAM("프로그램을 종료합니다."),
    CONTACT_ADDITION("연락처가 추가되었습니다.");



    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
