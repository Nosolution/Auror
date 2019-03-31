package org.seec.muggle.auror;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class AurorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AurorApplication.class, args);
        System.out.println("启动成功\n");
    }

}
