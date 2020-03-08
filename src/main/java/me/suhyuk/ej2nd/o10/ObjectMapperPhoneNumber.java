package me.suhyuk.ej2nd.o10;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import me.suhyuk.ej2nd.o09.PhoneNumber;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

public class ObjectMapperPhoneNumber extends PhoneNumber {

    public ObjectMapperPhoneNumber(int areaCode, int prefix, int lineNumber) {
        super(areaCode, prefix, lineNumber);
    }

    /**
     * PhoneNumber 객체의 문자열 표현을 반환한다
     * 문자열은 14자이며 형식은 "(XXX) YYY-ZZZZ"
     * XXX : 지역번호, YYY : 국번, ZZZZ : 선번호
     * 지정된 자리수가 다 채워지지 않은 경우는 0으로 채운다
     * 지역번호의 우 괄호 다음에 공백을 항상 추가한다
     * @return
     */
    @Override
    public String toString() {
        Map<String, Short> map = Collections.singletonMap("areaCode", getAreaCode());
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = null;
        try {
            jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }
}
