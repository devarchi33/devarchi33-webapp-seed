import com.devarchi33.web.config.MongoConfig;
import com.devarchi33.web.dao.crud.StudentCrud;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by donghoon on 2016. 1. 22..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoConfig.class, StudentCrud.class})
public class MongoBasicTest {

    private static final Logger logger = LoggerFactory.getLogger(MongoBasicTest.class);

    @Autowired
    StudentCrud studentCrud;

    @Test
    public void studentCountTest() {
        long count = studentCrud.schoolCount();
        assertEquals(200, count);
        logger.info("\r\n");
        logger.info("Student Count: " + count);
    }

}
