package com.s4dx.finder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class FinderTests {

    @Mock
    private Finder finder;

    @BeforeEach
    public void setup() {
        String[] thisIsAStringArray = new String[5];
        thisIsAStringArray[0] = "asd";
        thisIsAStringArray[1] = "asdd";
        thisIsAStringArray[2] = "fre";
        thisIsAStringArray[3] = "glk";
        thisIsAStringArray[4] = "lkm";
        finder = new Finder(thisIsAStringArray);
    }


    @Test
    void find() throws Exception {
        List<String> output = new ArrayList<>();
        output.add("asd");
        output.add("asdd");
        assertEquals(output, finder.find("sad"));


    }

    @Test
    public void findStrTest() throws Exception {
        assertEquals(1, finder.find("fre").size());

    }

    @Test
    public void notFindStrTest() throws Exception {
        assertEquals(0, finder.find("fsre").size());
    }

    @Test
    public void emptyArrayTest() throws Exception {
        String[] thisIsAStringArray = new String[0];
        finder = new Finder(thisIsAStringArray);

        assertThrows(Exception.class, () -> {
            finder.find("fsre");
        });

    }

    @Test
    public void emptyStrDataTest() throws Exception {
        String[] thisIsAStringArray = new String[1];
        thisIsAStringArray[0] = "";
        finder = new Finder(thisIsAStringArray);
        assertEquals(0, finder.find("fsre").size());

    }

    @Test
    public void checkInfiniteFindTest() throws Exception {
        for (int a = 0; a < 50000; a++) {
            String[] thisIsAStringArray = new String[5];

            thisIsAStringArray[0] = "asdd";
            thisIsAStringArray[1] = "";
            thisIsAStringArray[2] = "ddd";
            thisIsAStringArray[3] = "glk";
            thisIsAStringArray[4] = "sdwe";

            Finder finder = new Finder(thisIsAStringArray);
            finder.find("sad");
        }

    }

}
