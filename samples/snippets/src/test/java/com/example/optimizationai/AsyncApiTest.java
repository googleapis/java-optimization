/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.optimizationai;

// [START cloudoptimization_async_api]
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Tests for AsyncApi sample. */
public class AsyncApiTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String PROJECT_PARENT = String.format("projects/%s", PROJECT_ID);
  private static final String REQUEST_PATH = "resources/async_request.textproto";
  private static final String BUCKET_NAME = String.format("optimization-ai-output-test-%s", UUID.randomUUID());
  private static final String INPUT_URI = "gs://cloud-samples-data/optimization-ai/async_request_model.json";
  private static final String OUTPUT_PREFIX = 'code_snippets_test_output_'
  private static final String BATCH_OUTPUT_URI_PREFIX = String.format("gs://%s/%s", BUCKET_NAME, OUTPUT_PREFIX);
  
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static void cleanUpBucket() {
    Storage storage = StorageOptions.getDefaultInstance().getService();
    Page<Blob> blobs =
        storage.list(
            BUCKET_NAME,
            Storage.BlobListOption.currentDirectory(),
            Storage.BlobListOption.prefix(OUTPUT_PREFIX));

    deleteDirectory(storage, blobs);
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    Storage storage = StorageOptions.getDefaultInstance().getService();
    storage.create(BucketInfo.of(BUCKET_NAME));
  }

  @After
  public void tearDown() {
    cleanUpBucket();
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testAsyncApi() throws Exception {
    AsyncApi.callAsyncApi(PROJECT_PARENT, INPUT_URI, BATCH_OUTPUT_URI_PREFIX);
    String got = bout.toString();
    assertThat(got).contains("Job");
  }
}
// [END cloudoptimization_async_api]
