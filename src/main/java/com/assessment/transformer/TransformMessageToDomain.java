package com.assessment.transformer;

import com.assessment.beans.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Slf4j
public class TransformMessageToDomain {

    public Transaction transform(String record) throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File file = new File(classloader.getResource("mapping.xml").getFile());
        StreamFactory factory = StreamFactory.newInstance();
        factory.load(file);
        Unmarshaller unmarshaller = factory.createUnmarshaller("transactionstream");
        Transaction transaction = (Transaction) unmarshaller.unmarshal(record);
        log.info("Message is transformed to Transaction object successfully");
        return transaction;
    }
}
