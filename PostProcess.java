// camel-k: language=java

import org.apache.camel.builder.RouteBuilder;

public class PostProcess extends RouteBuilder {
  @Override
  public void configure() throws Exception {

      from("knative:event/file.uploaded")
        .log("A new file needs to be processed: ${body}...");

  }
}
