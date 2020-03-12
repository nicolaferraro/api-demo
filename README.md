# api-demo

Put the right credentials into the `application.properties` file.

To run it:

```
kamel run API.java --open-api openapi.yaml --property-file application.properties -t quarkus.enabled=true
kamel run PostProcess.java -t quarkus.enabled=true
```

To send an image data with CURL:
```
curl -i -X POST --header "Content-Type: application/octet-stream" --data-binary "@/path/to/img.png" http://api.namespace.cluster.net/
```
