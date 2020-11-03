package com.example.demo;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户单元测试类
 */
@Slf4j
public class DemoTestControllerTest extends WebFluxApplicationTests {


    /**
     * 测试get方法(参数在url中)
     *
     * @throws Exception
     */
    @Test
    public void getUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }


    /**
     * get方法  ?之后的参数
     */
    @Test
    public void getUserList() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/list")
//                .param("name", "cjy").param("phone", "1").
//                        param("pageNo","2").param("pageSize","3")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info("getUserList:"+mvcResult.getResponse().getContentAsString());
    }

    /**
     * 新增数据
     * @throws Exception
     */
    @Test
    public void addUser() throws Exception {
        Map<String,Object> map = new HashMap<>(4);
        map.put("name","nana");
        map.put("phone","188832");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(map)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }


    /**
     * 删
     * @throws Exception
     */
    @Test
    public void delUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/user/{id}",5)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }



    /**
     * 改
     */
    @Test
    public void updatUser() throws Exception {
        Map<String,Object> map = new HashMap<>(4);
        map.put("id","5");
        map.put("name","xxx");
        map.put("phone","1257318399");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/geek/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(JSON.toJSONString(map)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }
}