package com.example.optimizationai;

// [START cloudoptimization_async_api]
import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Tests for AsyncAPI sample. */
public class AsyncAPITest {
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testAsyncAPI() throws Exception {
    AsyncAPI.callAsyncAPI();
    String got = bout.toString();
    assertThat(got).contains("operations");
  }
}
// [END cloudoptimization_async_api]
