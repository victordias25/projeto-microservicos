package br.com.fornecedor.consumer.controller.service;

import com.squareup.okhttp.*;

import java.io.IOException;

public class EnvioDadosParaFaturamento {

    public void envioDadosParaFaturamento(String chassiVeiculo, String cnpjCliente, String dataFaturamento, String valorFaturamento) throws IOException, InterruptedException {
        System.out.println("chegou");

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n        " +
                "\"chassiVeiculo\": \"" + chassiVeiculo + "\",\n        " +
                "\n        \"cnpjCliente\": \"" + cnpjCliente + "\",\n        " +
                "\n        \"dataFaturamento\": \"" + dataFaturamento + "\",\n        " +
                "\n        \"valorFaturamento\": \""+valorFaturamento+"\"    " +
                "\n    }");
        Request request = new Request.Builder()
                .url("http://localhost:8070/faturamento/")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();

    }
}
