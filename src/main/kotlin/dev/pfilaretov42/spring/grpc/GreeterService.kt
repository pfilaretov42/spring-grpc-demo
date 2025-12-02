package dev.pfilaretov42.spring.grpc

import dev.pfilaretov42.spring.grpc.proto.GreeterGrpc
import dev.pfilaretov42.spring.grpc.proto.HelloReply
import dev.pfilaretov42.spring.grpc.proto.HelloRequest
import io.grpc.stub.StreamObserver
import org.springframework.grpc.server.service.GrpcService

@GrpcService
class GreeterService : GreeterGrpc.GreeterImplBase() {
    override fun sayHello(request: HelloRequest, responseObserver: StreamObserver<HelloReply>) {
        val name = request.name
        val message = if (name.isNullOrBlank()) "Hello!" else "Hello, $name!"

        val reply = HelloReply.newBuilder().setMessage(message).build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}
