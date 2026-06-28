package com.amr.graphql.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3StorageService {
    private final S3Client s3Client;

    public S3StorageService(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public void listObjects() {

        ListObjectsV2Request request = ListObjectsV2Request.builder()
                .bucket("graphql-s3-prjt1")
                .build();

        s3Client.listObjectsV2(request)
                .contents()
                .forEach(object ->
                        System.out.println("Found: " + object.key()));
    }

    public void uploadTestFile() {
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket("graphql-s3-prjt1")
                .key("test1.txt")
                .build();

        s3Client.putObject(request,
                RequestBody.fromString("This is fucking sick "));

        System.out.println("File Uploaded");
    }
}
