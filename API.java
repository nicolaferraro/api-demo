// camel-k: language=java

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class API extends RouteBuilder {
  @Override
  public void configure() throws Exception {

    from("direct:image")
      .bean(this, "validateImage")
      .setHeader("CamelAwsS3Key", simple("file_${random(999999)}.png"))
      .to("aws-s3://{{api.bucket}}")
      .wireTap("direct:notify")
      .setBody().constant("");

    from("direct:notify")
      .setBody().header("CamelAwsS3Key")
      .setHeader("Content-Type", constant("text/plain"))
      .to("knative:event/file.uploaded");

  }

  public void validateImage(Exchange ex) {
    // do some validation
  }

}
