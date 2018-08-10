package ua.crm.corporate.currencyUtiles;

import com.google.gson.Gson;
import ua.crm.corporate.model.CurrencyRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class CurrUtiles {
    public static List<CurrencyRate> getCurrencies () throws IOException {

        Gson gson = new Gson();
        final String PATH = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(PATH).openStream()));

        return Arrays.asList(gson.fromJson(bufferedReader, CurrencyRate[].class));
    }
}