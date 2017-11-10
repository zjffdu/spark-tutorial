/**
 * Created by jzhang on 5/2/15.
 */


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class TestMyClass {


    @Test
    public void test() {
        Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
            .create();
        Date date = new Date();
        String json = gson.toJson(date);
        System.out.println(date);
        Date date2 = gson.fromJson(json, Date.class);
        System.out.println(date2);
        assertEquals(date2, date);
    }
}
