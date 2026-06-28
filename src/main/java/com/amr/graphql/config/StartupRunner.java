package com.amr.graphql.config;

import com.amr.graphql.service.S3StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final S3StorageService s3StorageService;

    public StartupRunner(S3StorageService s3StorageService) {
        this.s3StorageService = s3StorageService;
    }

    @Override
    public void run(String... args) {
        s3StorageService.uploadTestFile();
    }
}
