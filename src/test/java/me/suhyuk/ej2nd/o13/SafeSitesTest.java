package me.suhyuk.ej2nd.o13;

import org.junit.Test;

import static org.junit.Assert.*;

public class SafeSitesTest {

    @Test
    public void 사이트_해킹() {
        String pornSite = "http://www.porn.com";
        SafeSites.LEGAL_SITES[0] = pornSite;
        assertTrue(SafeSites.isValid(pornSite));
    }

}