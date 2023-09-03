package org.sample.password;

/*
* 비밀번호는 최소 8자 이상 12자 이하
* 비밀번호가 8자 미만 또는 12자 초과한 경우 IllegalArgumentException 예외를 발생
* 경제조건에 대해 테스트 코드를 작성
* */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordValidatorTest {

    @Test
    void password가_최소8자이상_12자이하이다() {
        assertThatCode(() -> PasswordValidator.validate("password1234"))
                .doesNotThrowAnyException();

    }

    @ParameterizedTest
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})
    void password가_8자미만_12자초과하면_예외발생(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 합니다.");
    }
}
