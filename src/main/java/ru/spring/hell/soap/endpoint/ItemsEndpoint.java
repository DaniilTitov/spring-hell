package ru.spring.hell.soap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.spring.hell.soap.model.Items;
import ru.spring.hell.soap.model.Items.Item;

import java.math.BigInteger;

@Endpoint
public class ItemsEndpoint {
    @PayloadRoot(namespace = "http://bear.technology", localPart = "items")
    @ResponsePayload
    public Items getItems(@RequestPayload Items request) {
        Item item = new Item();
        item.setName("hello");
        item.setDiameter(BigInteger.ONE);
        item.setSize("small");
        Items response = new Items();
        response.getItem().add(item);
        return response;
    }
}
