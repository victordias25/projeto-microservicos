package br.com.fornecedor.consumer.controller.service;

import br.com.fornecedor.consumer.model.VendaConsignada;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class ConsultaDadosParaFaturar {
    public void consultaDadosParaFaturar(String message) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8070/vendaConsignada/find?chassiVeiculo=" + message)
                .get()
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            System.out.println("Chassi não encontrado");
        } else {
            try {
                String responseBody = response.body().string();
                String newReponseBody = responseBody.substring(1, responseBody.length() - 1);
                JSONObject jsonObject = new JSONObject(newReponseBody);
                System.out.println("Objeto : " + jsonObject.toString());

                Gson gson = new Gson();
                VendaConsignada objCliente = gson.fromJson(String.valueOf(jsonObject), VendaConsignada.class);

                String cnpjCliente = objCliente.getCnpjCliente();
                String chassiVeiculo = objCliente.getChassiVeiculo();
                String valorFaturamento = objCliente.getValorVendaConsignada();

                System.out.println("CNPJ Cliente: " + cnpjCliente);
                System.out.println("Chassi: " + chassiVeiculo);
                System.out.println("Valor para Faturar: " + valorFaturamento);

                java.util.Date d = new Date();
                String dataFaturamento = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

                EnvioDadosParaFaturamento envioDadosParaFaturamento = new EnvioDadosParaFaturamento();
                envioDadosParaFaturamento.envioDadosParaFaturamento(chassiVeiculo, cnpjCliente, dataFaturamento, valorFaturamento);

            } catch (JSONException | InterruptedException err) {
                System.out.println("Exception : " + err);
            }
        }
    }
}
