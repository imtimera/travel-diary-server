package com.kverchi.diary.service.impl;

import com.kverchi.diary.model.entity.User;
import com.kverchi.diary.model.form.RegistrationForm;
import com.kverchi.diary.repository.UserRepository;
import com.kverchi.diary.service.UserService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Liudmyla Melnychuk on 28.3.2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    static private MockHttpServletRequest request;

    @BeforeClass
    public static void generateMockServletRequest() {
        request = new MockHttpServletRequest();
        request.setServerPort(8080);
        request.setScheme("http");
    }
    @Ignore
    @Test
    public void testGenerateServerBaseUrl() throws Exception {
        String url = UserService.generateServerBaseUrl(request);
        assertEquals("http://localhost:8080", url);
    }
    @Ignore
    @Test
    public void testRegister() throws Exception {
        RegistrationForm form = new RegistrationForm("demo", "d3m0", "d3m0", "kverchi24@gmail.com");
        userService.register(form);
    }
    @Test
    public void testJPA() throws Exception {
        User cloneUser = userRepository.findByUsername("demo");
        logger.info("princess user: {}", cloneUser);
    }
}