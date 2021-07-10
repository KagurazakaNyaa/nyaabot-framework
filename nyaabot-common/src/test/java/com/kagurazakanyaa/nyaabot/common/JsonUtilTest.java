package com.kagurazakanyaa.nyaabot.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import lombok.Data;

/**
 * Unit test for simple App.
 */
class JsonUtilTest {

    @Data
    class TestBean {
        String field1;
        Integer field2;
    }

    @Test
    void jsonReadTest() throws IOException {
        String json = "{\"field1\":\"123\",\"field2\":123}";
        File jsonFile = new File("/tmp/testRead.json");
        var writer = new FileWriter(jsonFile);
        writer.write(json);
        writer.close();
        TestBean bean = JsonUtil.fromFile(jsonFile, TestBean.class);
        assertEquals("123", bean.getField1());
        assertEquals(123, bean.getField2());
        jsonFile.deleteOnExit();
    }

    @Test
    void jsonWriteTest() throws IOException {
        TestBean bean = new TestBean();
        bean.setField1("123");
        bean.setField2(123);
        File jsonFile = new File("/tmp/testWrite.json");
        JsonUtil.toFile(jsonFile, bean);
        var reader = new BufferedReader(new FileReader(jsonFile));
        assertNotNull(reader.readLine());
        reader.close();
        jsonFile.deleteOnExit();
    }
}
