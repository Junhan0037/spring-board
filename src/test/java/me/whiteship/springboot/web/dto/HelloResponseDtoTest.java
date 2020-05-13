package me.whiteship.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat; // 검증하고 싶은 대상을 메소드 인자로 받는다

public class HelloResponseDtoTest {

    @Test
    public void lombok_test() {
        //given
        String name = "abc";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
