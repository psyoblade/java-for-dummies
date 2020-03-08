package me.suhyuk.ej2nd.o10;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.suhyuk.ej2nd.o09.PhoneNumber;

@ToString
public class LombokPhoneNumber extends PhoneNumber {
    @Getter @Setter
    private String description;
    public LombokPhoneNumber(int areaCode, int prefix, int lineNumber) {
        super(areaCode, prefix, lineNumber);
    }
}
