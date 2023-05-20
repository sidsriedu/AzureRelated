package org.azure.readingBlobStorage;

import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class ReadingFromAzureBlobStorage {

    // example blobUrl = https://myaccount.blob.core.windows.net/container1/test/notes.txt
    private String blobUrl = "https://<storage-account-name>.blob.core.windows.net/<container-name>/<blob-path>";
    private static String clientId = "dehwjedbherg3uhdnendkpoqwk22ji1iodnkndjk";
    private static String clientSecret = "dehwjedbherg3uhdnendkpoqwk22ji1iodnkndjk";
    private static String tenantId = "dehwjedbherg3uhdnendkpoqwk22ji1iodnkndjk";

    public static void main(String[] args) {

        BlobServiceClient blobServiceClient = createBlobServiceClient();
        BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient("<container-name>");
        BlobClient blobClient = blobContainerClient.getBlobClient("<blob-path>");
        String data = blobClient.downloadContent().toString();
        System.out.println("data from blob: "+data);

    }

    private static BlobServiceClient createBlobServiceClient() {
        return new BlobServiceClientBuilder().credential(new ClientSecretCredentialBuilder().clientId(clientId).clientSecret(clientSecret).tenantId(tenantId).build())
                .endpoint("https://<storage-account-name>.blob.core.windows.net").buildClient();
    }


}
